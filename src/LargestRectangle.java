import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {
    static int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> st = new Stack<>();
        int n = A.size(), maxArea = 0, rightIdx = 0, leftIdx;

        for (; rightIdx < n; rightIdx++) {
            if (st.isEmpty() || A.get(st.peek()) <= A.get(rightIdx))
                st.push(rightIdx);
            else {
                while (!st.isEmpty() && A.get(st.peek()) > A.get(rightIdx)) {
                    int height = A.get(st.pop());

                    if (st.isEmpty()) leftIdx = -1;
                    else leftIdx = st.peek();

                    maxArea = Math.max(maxArea, height * (rightIdx - leftIdx - 1));
                }
                st.push(rightIdx);
            }
        }

        while (!st.isEmpty()) {
            int height = A.get(st.pop());

            if (st.isEmpty()) leftIdx = -1;
            else leftIdx = st.peek();

            maxArea = Math.max(maxArea, height * (rightIdx - leftIdx - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int res = largestRectangleArea(new ArrayList<>(Arrays.asList(90, 58, 69, 70, 82, 100, 13, 57, 47, 18)));
//        int res = largestRectangleArea(new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3)));

        System.out.println(res);
    }
}
