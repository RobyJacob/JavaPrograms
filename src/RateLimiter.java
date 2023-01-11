import java.util.*;

public class RateLimiter {
    static List<Boolean> rateLimiter(List<Integer> clientIds, List<Integer> times) {
        Map<Integer, Queue<Integer>> reqs = new HashMap<>();
        List<Boolean> res = new ArrayList<>();

        for (int i = 0; i < clientIds.size(); i++) {
            Integer clientId = clientIds.get(i);

            if (!reqs.containsKey(clientId)) {
                reqs.put(clientId, new LinkedList<>(List.of(times.get(i))));
                res.add(true);
            } else {
                Queue<Integer> queue = reqs.get(clientId);
                while (!queue.isEmpty()) {
                    if (Math.abs(times.get(i) - queue.peek()) >= 10) queue.poll();
                    else break;
                }
                if (reqs.get(clientId).size() < 3) {
                    res.add(true);
                    reqs.get(clientId).add(times.get(i));
                } else {
                    res.add(false);
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
      List<Boolean> reqStatus = rateLimiter(List.of(1, 1, 2, 1, 1, 1), List.of(1, 2, 2, 9, 10, 11));

      System.out.println(reqStatus);
    }
}
