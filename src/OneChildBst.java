import java.util.List;

public class OneChildBst {
    static String checkIfOneChildBst(List<Integer> preorder) {
        Integer l = Integer.MIN_VALUE, r = Integer.MAX_VALUE;
        Integer root = preorder.get(0);

        for (int i = 1; i < preorder.size(); i++) {
            if (preorder.get(i) > root)
                l = root;
            else if (preorder.get(i) < root)
                r = root;
            if (preorder.get(i) < l || preorder.get(i) > r)
                return "NO";
            root = preorder.get(i);
        }

        return "YES";
    }

    public static void main(String[] args) {
        String res = checkIfOneChildBst(List.of(1, 5, 4, 6));

        System.out.println(res);
    }
}