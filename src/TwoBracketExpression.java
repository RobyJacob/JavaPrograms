import java.util.HashMap;
import java.util.Stack;

public class TwoBracketExpression {
    static boolean convertToBoolean(char ch) {
        return ch == '+';
    }

    public static int checkExpression(String A, String B) {
        Stack<Boolean> opStack = new Stack<>();
        HashMap<Character, Boolean> operandSignA = new HashMap<>(), operandSignB = new HashMap<>();

        for (int i = 1; i < A.length(); i++) {
            char cur = A.charAt(i);
            boolean prevOp = true;
            if (A.charAt(i - 1) == '+' || A.charAt(i - 1) == '-')
                prevOp = convertToBoolean(A.charAt(i - 1));

            if (cur == '(') {
                if (!opStack.isEmpty()) opStack.push(!prevOp ^ opStack.peek());
                else opStack.push(prevOp);
            } else if (cur >= 'a' && cur <= 'z') {
                if (!opStack.isEmpty()) operandSignA.put(cur, !prevOp ^ opStack.peek());
                else operandSignA.put(cur, prevOp);
            } else if (cur == ')') if (!opStack.isEmpty()) opStack.pop();
        }

        for (int i = 1; i < B.length(); i++) {
            char cur = B.charAt(i);
            boolean prevOp = true;
            if (B.charAt(i - 1) == '+' || B.charAt(i - 1) == '-')
                prevOp = convertToBoolean(B.charAt(i - 1));

            if (cur == '(') {
                if (!opStack.isEmpty()) opStack.push(!prevOp ^ opStack.peek());
                else opStack.push(prevOp);
            } else if (cur >= 'a' && cur <= 'z') {
                if (!opStack.isEmpty()) operandSignB.put(cur, !prevOp ^ opStack.peek());
                else operandSignB.put(cur, prevOp);
            } else if (cur == ')') if (!opStack.isEmpty()) opStack.pop();
        }

        for (char operand : operandSignA.keySet()) {
            if (operandSignB.containsKey(operand)) {
                if (operandSignA.get(operand) != operandSignB.get(operand)) return 0;
            } else {
                if (!operandSignA.get(operand)) return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(checkExpression("-(-(-(-a+b)-d+c)-q)", "a-b-d+c+q"));
    }
}
