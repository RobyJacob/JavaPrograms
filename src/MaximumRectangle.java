import java.util.*;

public class MaximumRectangle {
    static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0, leftIdx, rightIdx = 0;

        for (; rightIdx < heights.length; rightIdx++) {
            if (st.isEmpty() || heights[rightIdx] >= heights[st.peek()]) {
                st.push(rightIdx);
            } else {
                while (!st.isEmpty() && heights[rightIdx] < heights[st.peek()]) {
                    int h = heights[st.pop()];

                    if (st.isEmpty()) leftIdx = -1;
                    else leftIdx = st.peek();

                    maxArea = Math.max(maxArea, h * (rightIdx - leftIdx - 1));
                }

                st.push(rightIdx);
            }
        }

        while (!st.isEmpty()) {
            int h = heights[st.pop()];

            if (st.isEmpty()) leftIdx = -1;
            else leftIdx = st.peek();

            maxArea = Math.max(maxArea, h * (rightIdx - leftIdx - 1));
        }

        return maxArea;
    }

    public static int solve(List<List<Integer>> A) {
        int r = A.size(), c = A.get(0).size(), maxArea = 0;
        int[][] heights = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (A.get(i).get(j) == 1) {
                    if (i > 0 && A.get(i - 1).get(j) == 1) heights[i][j] = heights[i - 1][j] + 1;
                    else heights[i][j] = 1;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights[i]));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int area = solve(new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(0, 0, 1),
                        Arrays.asList(0, 1, 1),
                        Arrays.asList(1, 1, 1)
                ))
        );

        System.out.println(area);
    }
}
