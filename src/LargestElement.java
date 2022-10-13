import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LargestElement {
    /*
    Return Kth largest element from given unsorted array.
    Eg:-
        Input = 3,2,1,5,6,4, K = 2
        Output = 5
     */

    static int largestElement(ArrayList<Integer> arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.size(); i++) {
            pq.add(arr.get(i));
        }

        int j = k - 1;
        while (j > 0) {
            pq.poll();
            j--;
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int result = largestElement(new ArrayList<>(Arrays.asList(3,2,1,5,6,4)), 2);

        System.out.println(result);
    }
}
