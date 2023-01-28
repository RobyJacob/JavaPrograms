import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class NumberOfSquareArrays {
    static int numOfSquareArrays(List<Integer> arr) {
        int res = 0;

        if (arr.stream().allMatch((num) -> Objects.equals(num, arr.get(0))))
            return 1;

        res = numOfSquareArraysHelper(0, arr.size() - 1, res, new ArrayList<>(arr));

        return res;
    }

    private static int numOfSquareArraysHelper(int left, int right, int res,
                                                ArrayList<Integer> tmp) {
        if (left == right) {
            if (isSquareArray(tmp)) res += 1;
            return res;
        }

        for (int i = left; i <= right; i++) {
            Collections.swap(tmp, left, i);
            res = numOfSquareArraysHelper(left + 1, right, res, tmp);
            Collections.swap(tmp, left, i);
        }

        return res;
    }

    private static boolean isSquareArray(ArrayList<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (!isSquare(arr.get(i - 1) + arr.get(i))) return false;
        }

        return true;
    }

    private static boolean isSquare(int num) {
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (i * i == num) return true;
        }

        return false;
    }

    public static void main(String[] args){
      int res = numOfSquareArrays(List.of(1, 17, 8));

      System.out.println(res);
    }
}
