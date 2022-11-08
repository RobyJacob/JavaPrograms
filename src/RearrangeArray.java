import java.util.Arrays;

public class RearrangeArray {
    static void rearrange(long[] arr) {
        int n = arr.length;
        long q = 0;

        for (long value : arr) {
            q = Math.max(q, value);
        }
        q++;

        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) arr[i] += (arr[r--] % q) * q;
            else arr[i] += (arr[l++] % q) * q;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / q;
        }
    }
    public static void main(String[] args) {
        long[] arr = new long[] {1, 2, 3, 4, 5, 6};

        rearrange(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }
}
