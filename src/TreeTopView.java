import java.util.*;

public class TreeTopView {
    static class Pair {
        Tree node;
        int dist;

        public Pair(Tree node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);

        List<Integer> topViewNodes = topView(tree);

        System.out.println(topViewNodes);
    }

    private static List<Integer> topView(Tree tree) {
        Queue<Pair> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        queue.add(new Pair(tree, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Tree curNode = pair.node;
            int curDist = pair.dist;

            if (!map.containsKey(curDist)) {
                map.put(curDist, new ArrayList<>(List.of(curNode.val)));
            }

            if (curNode.left != null)
                queue.add(new Pair(curNode.left, curDist - 1));
            if (curNode.right != null)
                queue.add(new Pair(curNode.right, curDist + 1));
        }

        map.forEach((key, value) -> result.addAll(value));

        return result;
    }
}
