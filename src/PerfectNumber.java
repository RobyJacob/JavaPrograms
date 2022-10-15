import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumber {
    static String perfectNumber(int A) {
        Queue<Long> queue = new LinkedList<>();
        int count = 0;
        String num = "";

        queue.add(1L);
        queue.add(2L);
        while (count < A) {
            long n = queue.remove();

            queue.add(n * 10 + 1);
            queue.add(n * 10 + 2);

            num = String.valueOf(n);

            count++;
        }

        StringBuilder rNum = new StringBuilder(num);
        num = num + rNum.reverse();

        return num;
    }
    public static void main(String[] args) {
        String perfectNum = perfectNumber(100);

        System.out.println(perfectNum);
    }
}
