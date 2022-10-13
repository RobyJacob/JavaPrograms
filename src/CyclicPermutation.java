public class CyclicPermutation {
    static int[] getZ(String pat, String txt) {
        String full = pat + "$" + txt;
        int[] z = new int[full.length()];
        int l = 0, r = 0, n = full.length();

        z[0] = n;

        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;

                while (r < n && full.charAt(r) == full.charAt(r - l))
                    r++;

                z[i] = r - l;
                r--;
            } else {
                int k = i - l;

                if (z[k] < r - i + 1)
                    z[i] = z[k];
                else {
                    l = i;

                    while (r < n && full.charAt(r) == full.charAt(r - l))
                        r++;

                    z[i] = r - l;
                    r--;
                }
            }
        }

        return z;
    }

    public static void main(String[] args) {
        String A = "1101111111";
        String B = "1101111111";

        String newB = B + B;
        int result = 0;

        int[] z = getZ(A, newB);

        for (int i = 1; i < z.length - B.length(); i++) {
            if (z[i] == A.length()) {
                result++;
            }
        }

        System.out.println(result);
    }
}
