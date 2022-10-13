import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {
    static String getCommonPrefix(String txt, String pat) {
        if (txt.isEmpty() || pat.isEmpty())
            return "";

        if (txt.length() < pat.length()) {
            String tmp = pat;
            pat = txt;
            txt = tmp;
        }

        String fullTxt = txt + "$" + pat;
        String commonPrefix = "";
        int n = fullTxt.length(), l = 0, r = 0, maxLen = 0;
        int[] z = new int[n];

        z[0] = n;

        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;

                while (r < n && fullTxt.charAt(r) == fullTxt.charAt(r - l))
                    r++;

                z[i] = r - l;
                r--;
            } else {
                int k = i - l;

                if (z[k] < r - i + 1)
                    z[i] = z[k];

                l = i;

                while (r < n && fullTxt.charAt(r) == fullTxt.charAt(r - l))
                    r++;

                z[i] = r - l;
                r--;
            }
        }

        int patStartIdx = txt.length() + 1;
        commonPrefix = fullTxt.substring(patStartIdx, patStartIdx + z[patStartIdx]);

        return commonPrefix;
    }
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(Arrays.asList(
                "aca",
                "cba"
        ));

        String lcp = input.get(0);

        for (int i = 1; i < input.size(); i++) {
            lcp = getCommonPrefix(lcp, input.get(i));
        }

        System.out.println(lcp);
    }
}
