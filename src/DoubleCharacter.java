import java.util.Stack;
import java.util.stream.Collectors;

public class DoubleCharacter {
    static String doubleCharacter(String A) {
        Stack<Character> st = new Stack<>();
        char[] chars = A.toCharArray();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            if (st.isEmpty() || st.peek() != chars[i])
                st.push(chars[i]);
            else
                st.pop();
        }

        st.forEach(res::append);

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(doubleCharacter("abbcd"));
    }
}
