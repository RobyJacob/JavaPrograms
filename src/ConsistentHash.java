import java.util.*;

public class ConsistentHash {
    private static int userHash(String username, int hashKey){
        final int n = 360;
        int hashCode = 0;
        long p_pow = 1;
        for (int i = 0; i < username.length(); i++) {
            char character = username.charAt(i);
            hashCode = (int) ((hashCode + (character - 'A' + 1) * p_pow) % n);
            p_pow = (p_pow * hashKey) % n;
        }
        return hashCode;
    }

    private static int add(String serverName, List<Integer> servers, Map<Integer, String> serverMappings,
                           Map<String, List<Integer>> serverData, Map<Integer, String> keyMappings, int hashKey) {
        int serverHash = userHash(serverName, hashKey);

        if (servers.isEmpty()) {
            servers.add(serverHash);
        } else {
            int low = 0, high = servers.size() - 1, mid = 0;

            while (low <= high) {
                mid = (low + high) / 2;

                if (servers.get(mid) < serverHash) {
                    low = mid + 1;
                } else if (servers.get(mid) > serverHash) {
                    high = mid - 1;
                } else {
                    return serverData.get(serverMappings.get(serverHash)).size();
                }
//                System.out.println(low + " " + mid + " " + high);
            }

//            if (low >= (servers.size() - 1))
//                servers.add(serverHash);
//            else
//                servers.add(low, serverHash);
            servers.add(low % (servers.size() + 1), serverHash);
        }
        serverMappings.put(serverHash, serverName);

        serverData.put(serverName, new ArrayList<>());

        Integer nextServerHash = servers.get((servers.indexOf(serverHash) + 1) % servers.size());
        List<Integer> keys = new ArrayList<>(serverData.get(serverMappings.get(nextServerHash)));
        serverData.get(serverMappings.get(nextServerHash)).clear();

        for (Integer key : keys) {
            assign(keyMappings.get(key), servers, serverMappings, serverData, keyMappings, hashKey);
        }

        return serverData.get(serverName).size();
    }

    private static int remove(String serverName, List<Integer> servers, Map<Integer, String> serverMappings,
                              Map<String, List<Integer>> serverData, Map<Integer, String> keyMappings, int hashKey) {
        int keysRemoved = 0;

        if (!servers.isEmpty()) {
            List<Integer> keys = new ArrayList<>(serverData.get(serverName));
            keysRemoved = keys.size();
            int serverHash = 0;
            for (Map.Entry<Integer, String> entry : serverMappings.entrySet()) {
                if (Objects.equals(entry.getValue(), serverName)) {
                    serverHash = entry.getKey();
                    break;
                }
            }
            servers.remove(Integer.valueOf(serverHash));
            serverMappings.remove(serverHash);
            serverData.remove(serverName);

            for (Integer key : keys) {
                assign(keyMappings.get(key), servers, serverMappings, serverData, keyMappings, hashKey);
            }
        }

        return keysRemoved;
    }

    private static int assign(String keyName, List<Integer> servers, Map<Integer, String> serverMappings,
                              Map<String, List<Integer>> serverData, Map<Integer, String> keyMappings, int hashKey) {
        int keyHash = userHash(keyName, hashKey);

        if (!servers.isEmpty()) {
            int low = 0, high = servers.size() - 1, mid = 0;

            while (low <= high) {
                mid = (low + high) / 2;

                int serverHash = servers.get(mid);
                if (serverHash == keyHash) {
                    serverData.get(serverMappings.get(serverHash)).add(keyHash);
                    return keyHash;
                } else if (serverHash > keyHash) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            serverData.get(serverMappings.get(servers.get(low % servers.size()))).add(keyHash);
            keyMappings.put(keyHash, keyName);
        }

        return keyHash;
    }

    static List<Integer> consistentHashing(List<String> queries, List<String> names, List<Integer> hashKeys) {
        int n = queries.size();
        List<Integer> res = new ArrayList<>();
        Map<Integer, String> serverMappings = new HashMap<>();
        List<Integer> servers = new ArrayList<>();
        Map<String, List<Integer>> serverData = new HashMap<>();
        Map<Integer, String> keyMappings = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (Objects.equals(queries.get(i), "ADD")) res.add(add(names.get(i), servers, serverMappings,
                    serverData, keyMappings, hashKeys.get(i)));
            else if (Objects.equals(queries.get(i), "ASSIGN")) res.add(assign(names.get(i), servers, serverMappings,
                    serverData, keyMappings, hashKeys.get(i)));
            else res.add(remove(names.get(i), servers, serverMappings, serverData, keyMappings, hashKeys.get(i)));
            System.out.println(i + 1 + " " + queries.get(i) + " " + servers + " " + serverData);
        }

        return res;
    }

    public static void main(String[] args) {
//        List<Integer> res = consistentHashing(new ArrayList<>(Arrays.asList(
//                "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN"
//        )), new ArrayList<>(Arrays.asList(
//                "INDIA", "XXWK", "HLFK", "XPUZ", "RUSSIA", "HYSP", "AYMS", "NZYJ", "CHINA", "MCVT", "SZXJ", "RPXJ", "GERMANY", "XXYV", "NECG", "MTAI", "INDIA", "UAQR", "PUZE", "LISG", "RUSSIA", "ZMYR", "NAKS", "RVDV", "CHINA", "EZUH", "OWCR"
//        )));

        System.out.println("GERMANY" + userHash("GERMANY", 139));
        List<Integer> res = consistentHashing(new ArrayList<>(Arrays.asList(
                "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN"
        )), new ArrayList<>(Arrays.asList(
                "INDIA", "VLVL", "OXXV", "HHGN", "RUSSIA", "AWNF", "SPHI", "FXKT", "CHINA", "JXZU", "BWPK", "JYWN", "GERMANY", "ZKYK", "HLQZ", "BRMS", "INDIA", "FMVA", "NPJO", "GACA", "RUSSIA", "ZMWM", "XVUA", "IDUW", "CHINA", "EHWW", "KROX"
        )), new ArrayList<>(Arrays.asList(
                431, 563, 223, 761, 197, 409, 31, 223, 769, 619, 991, 613, 139, 797, 547, 821, 859, 131, 577, 269, 2, 499, 599, 29, 449, 13, 337
        )));

        System.out.println(res);
    }
}
