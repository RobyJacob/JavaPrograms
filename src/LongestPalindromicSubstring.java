public class LongestPalindromicSubstring {
    static String longestPalindrome(String str) {
        String res = "";
        int resLen = 0;
        int n = str.length();

        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < n && str.charAt(l) == str.charAt(r)) {
                if (r - l + 1 > resLen) {
                    resLen = r - l + 1;
                    res = str.substring(l, r + 1);
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;

            while (l >= 0 && r < n && str.charAt(l) == str.charAt(r)) {
                if (r - l + 1 > resLen) {
                    resLen = r - l + 1;
                    res = str.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        String res = longestPalindrome("cbbd");

        System.out.println(res);
    }
}
