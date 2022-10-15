import java.util.Stack;

public class RedundantBraces {
    static boolean isOperator(Character ch) {
        return ch.equals('+') || ch.equals('-') || ch.equals('*') || ch.equals('/');
    }

    public static int braces(String A) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            if (ch == '(' || isOperator(ch))
                stack.push(ch);
            else if (ch == ')') {
                if (!stack.isEmpty() && !isOperator(stack.peek()))
                    return 1;
                while (!stack.isEmpty() && stack.pop() != '(');
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(braces("(a+((b*c))+d)"));
    }
}
