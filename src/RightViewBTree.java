import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class RightViewBTree {
    static class Pair {
        Node first;
        int second;

        Pair(Node node, int level) {
            first = node;
            second = level;
        }
    }

    static List<Integer> rightView(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int prevLevel = -1;

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            Node node = pair.first;
            int curLevel = pair.second;

            if (node.right != null) queue.add(new Pair(node.right, curLevel + 1));
            if (node.left != null) queue.add(new Pair(node.left, curLevel + 1));

            if (prevLevel != curLevel) res.add(node.val);

            prevLevel = curLevel;
        }

        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);

        List<Integer> rightViewNodes = rightView(root);

        System.out.println(rightViewNodes);
    }
}
