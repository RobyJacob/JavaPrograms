import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombination {
    static void generateLetterCombinations(String cur, String digits, List<String> res) {
        List<String> alpha = new ArrayList<>(Arrays.asList(
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        ));

        if (digits.isEmpty()) {
            if (cur.length() != 0) res.add(cur);
            return;
        }

        int dig = Integer.valueOf(String.valueOf(digits.charAt(0)));
        String digAlpha = alpha.get(dig - 2);

        for (int i = 0; i < digAlpha.length(); i++) {
            generateLetterCombinations(cur + digAlpha.charAt(i), digits.substring(1), res);
        }
    }
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();

        generateLetterCombinations("", "234", res);

        System.out.println(res);
    }
}
