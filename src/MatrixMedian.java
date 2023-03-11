import java.util.Arrays;

public class MatrixMedian {
    static int findMatrixMedian(int[][] mat) {
        int total = mat.length * mat[0].length;
        int desiredPartSize = total / 2;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int[] row : mat) {
            min = Math.min(min, row[0]);
            max = Math.max(max, row[row.length - 1]);
        }

        int i = min;
        int j = max;

        while (i <= j) {
            int mid = (i + j) / 2;

            int leftPartSize = 0;
            for (int[] row : mat) {
                int idx = Arrays.binarySearch(row, mid);
                if (idx < 0) idx = -1 * idx - 1;
                else if (idx < row.length) {
                    idx++;
                }
                leftPartSize += idx;
            }

            if (leftPartSize <= desiredPartSize) i = mid + 1;
            else j = mid - 1;
        }

        return i;
    }

    public static void main(String[] args) {
//        int[][] mat = new int[][] {
//                {1, 3, 5},
//                {2, 6, 9},
//                {3, 6, 9}
//        };

        int[][] mat = new int[][] {{5, 17, 100}};

        System.out.println(findMatrixMedian(mat));
    }
}
