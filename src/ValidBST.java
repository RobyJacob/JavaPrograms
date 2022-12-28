public class ValidBST {
    private static boolean valid = true;

    static class Pair {
        Integer min;
        Integer max;

        public Pair(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree(10);
        tree.left = new Tree(5);
        tree.right = new Tree(15);
        tree.left.left = new Tree(1);
        tree.left.right = new Tree(8);
        tree.right.right = new Tree(7);

//        Tree tree = new Tree(5);
//        tree.left = new Tree(3);
//        tree.right = new Tree(8);
//        tree.left.left = new Tree(1);
//        tree.left.right = new Tree(4);
//        tree.right.left = new Tree(7);
//        tree.right.right = new Tree(9);

        Pair treeRange = isValid(tree);

        System.out.println(valid);
    }

    private static Pair isValid(Tree tree) {
        if (tree == null) return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);

        Pair leftRange = isValid(tree.left);
        Pair rightRange = isValid(tree.right);

        if (tree.val <= leftRange.max || tree.val > rightRange.min)
            valid = false;

        return new Pair(Math.min(tree.val, leftRange.min), Math.max(tree.val, rightRange.max));
    }
}
