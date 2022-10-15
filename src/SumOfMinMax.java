import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinMax {
    public static int sumOfMinMax(ArrayList<Integer> A, int B) {
        Deque<Integer> maxQ = new LinkedList<>(), minQ = new LinkedList<>();
        int sum = 0;
        final int MOD = 1000000007;

        for (int i = 0; i < A.size(); i++) {
            if (i - B >= 0) {
                if (!maxQ.isEmpty() && maxQ.peekFirst().equals(A.get(i - B))) maxQ.removeFirst();
                if (!minQ.isEmpty() && minQ.peekFirst().equals(A.get(i - B))) minQ.removeFirst();
            }

            while (!maxQ.isEmpty() && maxQ.peekLast() < A.get(i)) maxQ.removeLast();
            while (!minQ.isEmpty() && minQ.peekLast() > A.get(i)) minQ.removeLast();

            maxQ.add(A.get(i));
            minQ.add(A.get(i));

            if (!maxQ.isEmpty() && i >= B - 1) {
                sum = (sum % MOD + minQ.peekFirst() % MOD + maxQ.peekFirst() % MOD) % MOD;
            }
        }

        return (sum + MOD) % MOD;
    }
    
    public static void main(String[] args) {
        int res = sumOfMinMax(new ArrayList<>(Arrays.asList(2,5,-1,7,-2,-3,5,1,2)), 3);

        System.out.println(res);
    }
}
