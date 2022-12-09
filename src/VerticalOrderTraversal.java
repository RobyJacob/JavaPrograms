import java.util.*;

public class VerticalOrderTraversal {
    static class Pair {
        Tree node;
        int depth;

        public Pair(Tree node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    static List<List<Integer>> verticalOrder(Tree root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int minDepth = Integer.MAX_VALUE;
        int maxDepth = Integer.MIN_VALUE;

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            Tree currentNode = pair.node;
            int depth = pair.depth;

            if (!map.containsKey(depth)) {
                map.put(depth, new ArrayList<>(List.of(currentNode.val)));
            } else {
                List<Integer> nodes = map.get(depth);
                nodes.add(currentNode.val);
                map.put(depth, nodes);
            }

            if (currentNode.left != null) queue.add(new Pair(currentNode.left, depth - 1));
            if (currentNode.right != null) queue.add(new Pair(currentNode.right, depth + 1));

            minDepth = Math.min(minDepth, depth);
            maxDepth = Math.max(maxDepth, depth);
        }

        for (int i = minDepth; i <= maxDepth; i++) {
            if (map.containsKey(i))
                res.add(map.get(i));
        }

        return res;
    }

    public static void main(String[] args) {
        Tree root = new Tree(6);
        root.left = new Tree(3);
        root.right = new Tree(7);
        root.left.left = new Tree(2);
        root.left.right = new Tree(5);
        root.right.right = new Tree(9);

        System.out.println(verticalOrder(root));
    }
}
