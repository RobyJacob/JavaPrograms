public class AthMagicalNum {
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int find_ath_magical_num(int a, int b, int c) {
        int low = Math.min(b, c);
        int high = a * low;
        final int MOD = (int) (Math.pow(10, 9) + 7);
        int lcm = (b * c) / gcd(b, c);

        while (low < high) {
            int mid = (low + high) / 2;
            int nth_magical_num = (mid / b) + (mid / c) - mid / lcm;
            if (nth_magical_num < a) low = mid + 1;
            else high = mid;
        }

        return low % MOD;
    }

    public static void main(String[] args) {
        int res = find_ath_magical_num(7, 2, 3);

        System.out.println(res);
    }
}
