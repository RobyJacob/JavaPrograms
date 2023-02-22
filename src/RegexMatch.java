public class RegexMatch {
    static boolean[][] memo;

    static boolean dp(int i, int j, String txt, String pat) {
        boolean ans;

        if (j == pat.length()) ans = i == txt.length();
        else {
            boolean curMatch = i < txt.length() && (pat.charAt(j) == txt.charAt(i) || pat.charAt(j) == '.');
            if (j + 1 < pat.length() && pat.charAt(j + 1) == '*')
                ans = dp(i, j + 2, txt, pat) || (curMatch && dp(i + 1, j, txt, pat));
            else
                ans = curMatch && dp(i + 1, j + 1, txt, pat);
        }

        memo[i][j] = ans;

        return memo[i][j];
    }

    static boolean fullMatch(String txt, String pat) {
        memo = new boolean[txt.length() + 1][pat.length() + 1];

        return dp(0, 0, txt, pat);
    }

    public static void main(String[] args){
      boolean matched = fullMatch("ab", ".*");

      System.out.println(matched);
    }
}
