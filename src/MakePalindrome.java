public class MakePalindrome {
    static int[] getZ(String pat, String txt) {
        String full = pat + "$" + txt;
        int l = 0, r = 0, n = full.length();
        int[] z = new int[n];
        z[0] = n;

        for(int i = 1; i < n; i++) {
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

    public static void main(String[] args) {
        String A = "eylfpbnpljvrvipyamyehwqnq";

        int[] z = getZ(A, new StringBuilder(A).reverse().toString());
        int maxLenPalindrome = 0;

        for (int i = 1; i < z.length; i++) {
            if (z[i] == z.length - i) {
                maxLenPalindrome = z[i];
                break;
            }
        }

        System.out.println(A.length() - maxLenPalindrome);
    }
}
