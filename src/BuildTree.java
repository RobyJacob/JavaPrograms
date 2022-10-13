import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }
}

public class BuildTree {
    static TreeNode buildTree(List<Integer> inorder, List<Integer> postorder, int st, int end, int pos) {
        if (st > end) return null;
        if (st == end) return new TreeNode(inorder.get(st));

        TreeNode root = new TreeNode(postorder.get(pos));

        int idx = -1;

        for (int i = st; i <= end; i++) {
            if (inorder.get(i) == root.val) {
                idx = -1;
                break;
            }
        }

        root.left = buildTree(inorder, postorder, st, idx - 1, pos - (end - idx) - 1);
        root.right = buildTree(inorder, postorder, idx + 1, end, pos - 1);

        return root;
    }

    public static void main(String[] args) {
        List<Integer> in = Arrays.asList(6, 1, 3, 2);
        List<Integer> post = Arrays.asList(6, 3, 2, 1);

        buildTree(in, post, 0, in.size() - 1, post.size() - 1);
    }
}
