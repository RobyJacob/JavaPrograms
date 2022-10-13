import java.util.Stack;

public class InfixExpressionEvaluate {
    /*
    Given infix form of an expression, evaluate the expression.
    Eg:-
        Input = "1+3-1+2"
        Output = 5
     */

    static boolean isOperator(char chr) {
        if (chr == '+' || chr == '-' || chr == '*' || chr == '/')
            return true;
        return false;
    }

    static int getPrecedence(char chr) {
        if (chr == '+' || chr == '-')
            return 1;
        else if (chr == '*' || chr == '/')
            return 2;
        return 0;
    }

    static int evaluate(String expr) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        char[] exprChars = expr.toCharArray();

        for (int i = 0; i < exprChars.length; i++) {
            if (exprChars[i] == ' ')
                continue;

            if (exprChars[i] >= '0' && exprChars[i] <= '9') {
                values.push(Integer.parseInt(String.valueOf(exprChars[i])));
            } else if (isOperator(exprChars[i])) {
                while (!ops.isEmpty() && (getPrecedence(ops.peek()) >= getPrecedence(exprChars[i]))) {
                    char op = ops.pop();
                    int operand1 = values.pop(), operand2 = values.pop(), result = 0;
                    if (op == '+')
                        result = operand1 + operand2;
                    else if (op == '-')
                        result = operand1 - operand2;
                    else if (op == '*')
                        result = operand1 * operand2;
                    else if (op == '/')
                        result = operand1 / operand2;
                    values.push(result);
                }
                ops.push(exprChars[i]);
            }
        }

        while (!ops.isEmpty()) {
            char op = ops.pop();
            int operand1 = values.pop(), operand2 = values.pop(), result = 0;
            if (op == '+')
                result = operand1 + operand2;
            else if (op == '-')
                result = operand1 - operand2;
            else if (op == '*')
                result = operand1 * operand2;
            else if (op == '/')
                result = operand1 / operand2;
            values.push(result);
        }

        return values.peek();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("2*3+2"));
    }
}
