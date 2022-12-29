public class LargestSubBST {
    static class Pair {
        Integer min;
        Integer max;
        Integer size;

        public Pair(Integer min, Integer max, Integer size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    public static void main(String[] args) {
        Tree tree = new Tree(10);
        tree.left = new Tree(5);
        tree.right = new Tree(15);
        tree.left.left = new Tree(1);
        tree.left.right = new Tree(8);
        tree.right.right = new Tree(7);

        Pair pair = largestSubBst(tree);

        System.out.println(pair.size);
    }

    private static Pair largestSubBst(Tree tree) {
        if (tree == null) return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        Pair leftRange = largestSubBst(tree.left);
        Pair rightRange = largestSubBst(tree.right);

        if (tree.val <= leftRange.max || tree.val > rightRange.min)
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(leftRange.size, rightRange.size));

        return new Pair(Math.min(leftRange.min, tree.val), Math.max(rightRange.max, tree.val),
                1 + leftRange.size + rightRange.size);
    }
}
