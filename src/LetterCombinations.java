import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    static List<String> letterCombinations(String digitString) {
        List<String> combinations = new ArrayList<>();
        Map<Integer, String> letterMap = new HashMap<>();
        letterMap.put(0, "0");
        letterMap.put(1, "1");
        letterMap.put(2, "abc");
        letterMap.put(3, "def");
        letterMap.put(4, "ghi");
        letterMap.put(5, "jkl");
        letterMap.put(6, "mno");
        letterMap.put(7, "pqrs");
        letterMap.put(8, "tuv");
        letterMap.put(9, "xyz");

        letterCombinationsHelper(digitString.length(), digitString, combinations, new StringBuilder(), letterMap, 0);

        return combinations;
    }

    private static void letterCombinationsHelper(int length, String digitString, List<String> combinations,
                                                 StringBuilder tmp, Map<Integer, String> letterMap, int idx) {
        if (idx == length) {
            combinations.add(tmp.toString());
            return;
        }

        String letters = letterMap.get(digitString.charAt(idx) - '0');
        for (int i = 0; i < letters.length(); i++) {
            tmp.append(letters.charAt(i));
            letterCombinationsHelper(length, digitString, combinations, tmp, letterMap, idx + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public static void main(String[] args){
      List<String> res = letterCombinations("012");

      System.out.println(res);
    }
}
