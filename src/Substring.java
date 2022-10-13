public class Substring {
    static int substring(String text, String pat) {
        String concat = pat + "$" + text;
        int idx = -1, n = concat.length(), l = 0, r = 0,
                patLength = pat.length();
        int[] z = new int[n];
        z[0] = n;

        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;

                while (r < n && concat.charAt(r - l) == concat.charAt(r))
                    r++;

                z[i] = r - l;
                r--;
            } else {
                int k = i - l;

                if (z[k] < r - i + 1)
                    z[i] = z[k];
                else {
                    l = i;
                    while (r < n && concat.charAt(r - l) == concat.charAt(r))
                        r++;

                    z[i] = r - l;
                    r--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (z[i] == patLength)
                idx = i;
        }

        return idx - patLength - 1;
    }

    public static void main(String[] args) {
        int idx = substring("robyjacob", "byj");

        System.out.println(idx);
    }
}
