import java.util.HashMap;
import java.util.Map;

public class SortedPermutationRank {
    static final int MOD = 1000003;

    static int fact(int num) {
        if (num == 0 || num == 1)
            return 1;

        return (num * fact(num - 1)) % MOD;
    }

    static long pow(long a, long b, long mod) {
        long result = 1;

        while (b > 0) {
            if (b % 2 != 0)
                result = (result * a) % MOD;

            a = (a * a) % MOD;
            b = b / 2;
        }

        return result;
    }

    /*
    Given a string A. Find the rank of the string amongst its permutations
    sorted lexicographically. Assume that no characters are repeated.
    Eg:-
        Input = "acb"
        Output = 2
     */
    static int findRankWithoutRepeats(String A) {
        int count = 0, n = A.length(), ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(j) < A.charAt(i))
                    count++;
            }

            ans += (count * fact(n - i - 1));
        }

        return (ans + 1) % MOD;
    }

    /*
    Given a string A. Find the rank of the string amongst its permutations
    sorted lexicographically. Characters can repeat.
    Eg:-
        Input = "baa"
        Output = 3
     */
    static int findRankWithRepeats(String A) {
        int n = A.length(), count;
        long r, result = 0;

        for (int i = 0; i < n; i++) {
            count = 0;
            r = 1L;

            for (int j = i + 1; j < n; j++) {
                if (A.charAt(i) > A.charAt(j))
                    count++;
            }

            HashMap<Character, Integer> freqMap = new HashMap<>();
            for (int k = i; k < n; k++) {
                if (freqMap.containsKey(A.charAt(k)))
                    freqMap.put(A.charAt(k), freqMap.get(A.charAt(k)) + 1);
                else
                    freqMap.put(A.charAt(k), 1);
            }

            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                r = (r * fact(entry.getValue())) % MOD;
            }

            result += (count * fact(n - i - 1) * pow(r, MOD - 2, MOD)) % MOD;
        }

        return Long.valueOf((result + 1) % MOD).intValue();
    }

    public static void main(String[] args) {
        int result1 = findRankWithRepeats("bbbbaaaa");
        int result2 = findRankWithoutRepeats("bcd");

        System.out.println(result1);
        System.out.println(result2);
    }
}
