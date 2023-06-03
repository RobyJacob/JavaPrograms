import java.util.Arrays;

public class AggressiveCows {
    static int allocateCows(int[] stalls, int cows) {
        Arrays.sort(stalls);

        int l = 0, h = stalls[stalls.length - 1];

        int ans = 0;
        while (l <= h) {
            int mid = (l + h) / 2;

            if (isPossible(stalls, mid, cows)) {
                l = mid + 1;
                ans = mid;
            } else {
                h = mid - 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] stalls, int dist, int cows) {
        int pos = stalls[0];
        int numOfCows = cows - 1;

        for (int i = 1; i < stalls.length; i++) {
            int nextDist = stalls[i] - pos;
            if (nextDist >= dist) {
                pos = stalls[i];
                numOfCows--;
            }
        }

        return numOfCows <= 0;
    }

    public static void main(String[] args) {
        int[] stalls = new int[] {1, 2, 3, 4, 5};
        int res1 = allocateCows(stalls, 3); // 2

        stalls = new int[] {5, 7, 100, 11};
        int res2 = allocateCows(stalls, 2); // 95

        stalls = new int[] {82, 61, 38, 88, 12, 7, 6, 12, 48, 8, 31, 90, 35, 5, 88, 2, 66, 19, 5, 96, 84, 95};
        int res3 = allocateCows(stalls, 8); // 7

        stalls = new int[] {0, 100};
        int res4 = allocateCows(stalls, 2); // 100

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }
}
