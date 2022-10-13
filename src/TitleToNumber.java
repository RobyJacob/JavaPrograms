import java.util.HashMap;

public class TitleToNumber {
    /*
    Given a String/title convert to respective column number
    Eg:-
        Input = "AABC"
        Output = 18307
     */

    static int titleToNumber(String A) {
        HashMap<Character, Integer> letterMap = new HashMap<>();
        StringBuilder input = new StringBuilder(A);
        int result = 0;

        for (int i = 1; i <= 26; i++) {
            letterMap.put((char) (65 + i - 1), i);
        }

        input.reverse();
        for (int i = 0; i < input.length(); i++) {
            result += (Math.pow(26, i) * letterMap.get(input.charAt(i)));
        }

        return result;
    }

    public static void main(String[] args) {
        int result = titleToNumber("AABC");
        System.out.println(result);
    }
}
