import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewBTree {
    static class Pair {
        Tree first;
        int second;

        Pair(Tree node, int level) {
            first = node;
            second = level;
        }
    }

    static List<Integer> rightView(Tree root) {
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int prevLevel = -1;

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            Tree node = pair.first;
            int curLevel = pair.second;

            if (node.right != null) queue.add(new Pair(node.right, curLevel + 1));
            if (node.left != null) queue.add(new Pair(node.left, curLevel + 1));

            if (prevLevel != curLevel) res.add(node.val);

            prevLevel = curLevel;
        }

        return res;
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);
        root.left.left.left = new Tree(8);

        List<Integer> rightViewNodes = rightView(root);

        System.out.println(rightViewNodes);
    }
}
