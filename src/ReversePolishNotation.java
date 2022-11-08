import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class ReversePolishNotation {
    static int evaluate(ArrayList<String> A) {
        Stack<Integer> st = new Stack<>();

        for (String ele : A) {
            if (!Objects.equals(ele, "+") && !Objects.equals(ele, "-")
                    && !Objects.equals(ele, "*") && !Objects.equals(ele, "/"))
                st.push(Integer.valueOf(ele));
            else {
                int op1 = st.pop();
                int op2 = st.pop();

                switch (ele) {
                    case "+":
                        st.push(op2 + op1);
                        break;
                    case "-":
                        st.push(op2 - op1);
                        break;
                    case "*":
                        st.push(op2 * op1);
                        break;
                    case "/":
                        st.push(op2 / op1);
                        break;
                }
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        int res = evaluate(new ArrayList<>(Arrays.asList("2", "2", "/")));

        System.out.println(res);
    }
}
