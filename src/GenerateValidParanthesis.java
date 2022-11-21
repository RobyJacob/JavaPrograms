import java.util.ArrayList;
import java.util.List;

public class GenerateValidParanthesis {
    static void generateValidParanthesis(StringBuilder cur, List<String> res, int open, int close, int n) {
        if (cur.length() == n * 2) {
            res.add(cur.toString());
            return;
        }

        if (open < n) {
            cur.append("(");
            generateValidParanthesis(cur, res, open + 1, close, n);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open) {
            cur.append(")");
            generateValidParanthesis(cur, res, open, close + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 10;

        List<String> res = new ArrayList<>();

        generateValidParanthesis(new StringBuilder(), res, 0, 0, n);

        System.out.println(res);
    }
}
