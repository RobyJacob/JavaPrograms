import java.util.*;

public class ZigZagTraversal {
    private static class Pair {
        Tree node;
        int level;

        public Pair(Tree node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree(3);
        tree.left = new Tree(9);
        tree.right = new Tree(20);
        tree.right.left = new Tree(15);
        tree.right.right = new Tree(40);

        List<List<Integer>> zigZagViewNodes = zigZagTraversal(tree);

        System.out.println(zigZagViewNodes);
    }

    private static List<List<Integer>> zigZagTraversal(Tree tree) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        int prevLevel = 0;
        List<Integer> tmpList = new ArrayList<>();

        queue.add(new Pair(tree, 1));
        tmpList.add(tree.val);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Tree curNode = pair.node;
            int curLevel = pair.level;

            if (prevLevel != curLevel) {
                if (curLevel % 2 == 0)
                    Collections.reverse(tmpList);
                res.add(tmpList);
                tmpList = new ArrayList<>();
            }

            if (curNode.left != null) {
                queue.add(new Pair(curNode.left, curLevel + 1));
                tmpList.add(curNode.left.val);
            }
            if (curNode.right != null) {
                queue.add(new Pair(curNode.right, curLevel + 1));
                tmpList.add(curNode.right.val);
            }

            prevLevel = curLevel;
        }

        return res;
    }
}
