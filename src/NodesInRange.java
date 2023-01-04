public class NodesInRange {
    private static int countRange(Tree tree, int lower, int upper) {
        if (tree == null) return 0;

        if (tree.val >= lower && tree.val <= upper)
            return 1 + countRange(tree.left, lower, upper) + countRange(tree.right, lower, upper);
        else if (tree.val < lower)
            return countRange(tree.right, lower, upper);
        else return countRange(tree.left, lower, upper);
    }

    public static void main(String[] args) {
        Tree root = new Tree(15);
        root.left = new Tree(12);
        root.right = new Tree(20);
        root.left.left = new Tree(10);
        root.left.right = new Tree(14);
        root.right.left = new Tree(16);
        root.right.right = new Tree(27);
        root.left.left.left = new Tree(8);

        int count = countRange(root, 12, 20);

        System.out.println(count);
    }
}
