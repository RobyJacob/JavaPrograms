import java.util.ArrayList;
import java.util.List;

public class TwoSumBst {
    static void inorder(Tree root, List<Tree> arr) {
        if (root == null) return;

        inorder(root.left, arr);
        arr.add(root);
        inorder(root.right, arr);
    }

    static boolean isTwoSumExist(Tree root, int sum) {
        List<Tree> arr = new ArrayList<>();

        inorder(root, arr);

        int i = 0, j = arr.size() - 1;

        while (i < j) {
            int val = arr.get(i).val + arr.get(j).val;

            if (val == sum) return true;

            if (val < sum) i++;
            else j--;
        }

        return false;
    }

    public static void main(String[] args) {
        Tree root = new Tree(10);
        root.left = new Tree(9);
        root.right = new Tree(20);

        System.out.println(isTwoSumExist(root, 19));
    }
}
