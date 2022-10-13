import java.util.HashMap;

public class ExcelColumnTitle {
    /*
    Given a number convert to corresponding letter column title
    Eg:-
        Input = 1
        Output = A

        Input = 27
        Output = AA
     */

    static String convertToTitle(long num) {
        HashMap<Long, Character> letterMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (long i = 0; i < 26; i++) {
            letterMap.put(i, (char) (65 + i));
        }

        while (num != 0) {
            num--;
            result.insert(0, letterMap.get(num % 26));
            num /= 26;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String result = convertToTitle(18307);
        System.out.println(result);
    }
}
