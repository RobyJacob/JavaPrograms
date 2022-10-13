public class MinimumPeriod {
    static int[] getZ(String pat, String txt) {
        String full = pat + "$" + txt;
        int l = 0, r = 0, n = full.length();
        int[] z = new int[n];

        z[0] = n;

        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;

                while (r < n && full.charAt(r) == full.charAt(r - l)) r++;

                z[i] = r - l;
                r--;
            } else {
                int k = i - l;

                if (z[k] < r - i + 1)
                    z[i] = z[k];
                else {
                    l = i;

                    while (r < n && full.charAt(r) == full.charAt(r - l)) r++;

                    z[i] = r - l;
                    r--;
                }
            }
        }

        return z;
    }

    static int getMinimumPeriod(String str) {
        int[] z = getZ(str, str);

        for (int i = 1; i < z.length; i++) {
            if (i + z[i] == str.length())
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "abcdefg";

        System.out.println(getMinimumPeriod(str));
    }
}
