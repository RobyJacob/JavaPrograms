import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
    static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (Integer integer : A) {
            if (st.isEmpty()) {
                st.push(integer);
                res.add(-1);
            } else {
                if (st.peek() < integer) {
                    res.add(st.peek());
                    st.push(integer);
                } else {
                    while (!st.isEmpty() && st.peek() >= integer) st.pop();
                    if (!st.isEmpty()) res.add(st.peek());
                    else res.add(-1);
                    st.push(integer);
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
//        System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(34, 35, 27, 42, 5, 28, 39, 20, 28))));
//        System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8))));
        System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(39, 27, 11, 4, 24, 32, 32, 1))));
    }
}
