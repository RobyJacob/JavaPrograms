import java.util.Arrays;

public class MinSegmentTree {
    int[] tree;

    MinSegmentTree(int n) {
        tree = new int[2 * n];
    }

    void build(int[] arr, int idx, int st, int end) {
        if (st == end) tree[idx] = arr[st];
        else {
            int mid = (st + end) / 2;
            int lc = 2 * idx + 1;
            int rc = 2 * idx + 2;
            build(arr, lc, st, mid);
            build(arr, rc, mid + 1, end);
            tree[idx] = Math.min(tree[lc], tree[rc]);
        }
    }

    int query(int idx, int st, int end, int l, int r) {
        if (l <= st && end <= r) return tree[idx];
        if (r < st || end < l) return Integer.MAX_VALUE;

        int mid = (st + end) / 2;
        int lc = 2 * idx + 1, rc = 2 * idx + 2;

        return Math.min(query(lc, st, mid, l, r), query(rc, mid + 1, end, l, r));
    }

    void update(int idx, int st, int end, int idxToUpdate, int value) {
        if (st == end) tree[idx] = value;
        else {
            int mid = (st + end) / 2;
            int lc = 2 * idx + 1;
            int rc = 2 * idx + 2;
            if (st <= idxToUpdate && idxToUpdate <= mid)
                update(lc, st, mid, idxToUpdate, value);
            else
                update(rc, mid + 1, end, idxToUpdate, value);
            tree[idx] = Math.min(tree[lc], tree[rc]);
        }
    }

    public static void main(String[] args){
      MinSegmentTree minSegmentTree = new MinSegmentTree(3);

      int[] arr = {1, 4, 1};

      minSegmentTree.build(arr, 0, 0, arr.length - 1);

      System.out.println("Segment tree build");
      Arrays.stream(minSegmentTree.tree).forEach(System.out::print);

      int res = minSegmentTree.query(0, 0, arr.length - 1, 1, 2);

      System.out.println("\nSegment tree query");
      System.out.println(res);

      minSegmentTree.update(0, 0, arr.length - 1, 1, -1);

      System.out.println("Segment tree update");
      Arrays.stream(minSegmentTree.tree).forEach(System.out::print);

      res = minSegmentTree.query(0, 0, arr.length - 1, 1, 2);

      System.out.println("\nSegment tree query");
      System.out.println(res);
    }
}
