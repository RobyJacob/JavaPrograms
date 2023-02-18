public class ShortestPalindrome {
    static String generateShortestPalindrome(String inputStr) {
        int[] z = GenerateZArray.generate(new StringBuilder(inputStr).reverse().toString(), inputStr);

        int max_len = 0;

        for (int i = 1; i < z.length; i++) {
            if (i + z[i] == z.length) {
                max_len = z[i];
                break;
            }
        }

        return new StringBuilder(inputStr.substring(max_len)).reverse().append(inputStr).toString();
    }

    public static void main(String[] args){
      System.out.println(generateShortestPalindrome("ababaa"));
    }
}
