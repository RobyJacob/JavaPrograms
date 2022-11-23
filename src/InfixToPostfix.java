import java.util.Stack;

public class InfixToPostfix {
    static String infixToPostfix(String infix) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (char ch : infix.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                res.append(ch);
            else if (ch == '(')
                st.push(ch);
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(')
                    res.append(st.pop());
                st.pop();
            } else {
                while (!st.isEmpty() && st.peek() != '(' && precedence(ch) <= precedence(st.peek()))
                    res.append(st.pop());
                st.push(ch);
            }
        }

        while (!st.isEmpty() && st.peek() != '(')
            res.append(st.pop());

        return res.toString();
    }

    private static int precedence(char op) {
        switch (op) {
            case '^': return 3;
            case '*': return 2;
            case '/': return 2;
            case '+': return 1;
            case '-': return 1;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }
}
