import java.util.ArrayList;

public class ReverseWords {
    static String reverseWords(String str) {
        String trimmedStr = str.trim();
        ArrayList<String> words = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        String word = "";
        int i = 0;
        while (i < trimmedStr.length()) {
            if (trimmedStr.charAt(i) != ' ') {
                word += trimmedStr.charAt(i);
            } else {
                words.add(word);
                while (i < trimmedStr.length() && trimmedStr.charAt(i) == ' ') i++;
                i--;
                word = "";
            }
            i++;
        }
        words.add(word);

        for (i = words.size() - 1; i >= 0; i--) {
            result.append(words.get(i)).append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv "));
    }
}
