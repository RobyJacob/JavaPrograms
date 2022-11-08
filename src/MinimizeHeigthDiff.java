import java.util.Arrays;

public class MinimizeHeigthDiff {
    static int minimumHeigthDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];

        int small, min = arr[0] + k, max = arr[n - 1] - k;
        for (int i = 0; i < n - 1; i++) {
            small = Math.min(min, arr[i + 1] - k);
            if (small < 0) continue;
            ans = Math.min(ans, Math.max(max, arr[i] + k) - small);
        }

        return ans;
    }

    public static void main(String[] args) {
        int res = minimumHeigthDiff(new int[]{1,1,1,2,5,6,7,9,9,10}, 4);

        System.out.println(res);
    }
}
