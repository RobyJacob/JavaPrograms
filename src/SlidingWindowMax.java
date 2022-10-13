import java.util.*;

public class SlidingWindowMax {
    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < A.size(); i++) {
            if (i - B >= 0) {
                if (queue.peekFirst() == A.get(i - B)) queue.removeFirst();
            }

            while (!queue.isEmpty() && queue.peekLast() < A.get(i)) queue.removeLast();
            queue.addLast(A.get(i));

            if (i >= B - 1)
                res.add(queue.peekFirst());
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(slidingMaximum(new ArrayList<>(Arrays.asList(648,614,490,138,657,544,745,582,738,229,775,665,876,448,4,81,807,578,712,951,867,328,308,440,542,178,637,446,882,760,354,523,935,277,158,698,536,165,892,327,574,516,36,705,900,482,558,937,207,368)), 9));
    }
}
