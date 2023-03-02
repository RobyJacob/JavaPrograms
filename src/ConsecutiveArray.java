import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsecutiveArray {
    static boolean isConsecutiveArray(List<Integer> arr) {
        int minVal = Collections.min(arr), maxVal = Collections.max(arr);
        int total = (arr.size() * (2 * minVal + (arr.size() - 1))) / 2;

        for (int num : arr) {
            total -= num;
            if (total < 0) break;
        }

        return total == 0;
    }

    public static void main(String[] args){
      System.out.println(isConsecutiveArray(new ArrayList<>(List.of(1, 3, 2, 5))));
      System.out.println(isConsecutiveArray(new ArrayList<>(List.of(3,2,1,4,5))));
    }
}
