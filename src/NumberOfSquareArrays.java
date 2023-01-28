import java.util.*;

public class NumberOfSquareArrays {
    static int numOfSquareArrays(List<Integer> arr) {
        int res = 0;

        if (arr.size() == 1) return 0;
        if (arr.stream().allMatch((num) -> Objects.equals(num, arr.get(0))) &&
                isPerfectSquare(arr.get(0) + arr.get(1)))
            return 1;

        res = numOfSquareArraysHelper(0, arr.size() - 1, res, new ArrayList<>(arr),
                new HashSet<>());

        return res;
    }

    private static int numOfSquareArraysHelper(int left, int right, int res,
                                               ArrayList<Integer> tmp, Set<ArrayList<Integer>> visited) {
        if (left == right) {
            visited.add(tmp);
            return isPerfectSquare(tmp.get(left) + tmp.get(left - 1)) ? ++res : res;
        }

        for (int i = left; i <= right; i++) {
            if (i != left && tmp.get(i).equals(tmp.get(left))) continue;
            Collections.swap(tmp, left, i);
            if (left == 0 || (left > 0 && isPerfectSquare(tmp.get(left - 1) + tmp.get(left)) &&
                    !visited.contains(tmp)))
                res = numOfSquareArraysHelper(left + 1, right, res, tmp, visited);
            Collections.swap(tmp, left, i);
        }

        return res;
    }

    private static boolean isPerfectSquare(int num) {
        int n = (int) Math.sqrt(num);

        return (n * n) == num;
    }

    public static void main(String[] args){
      int res = numOfSquareArrays(List.of(36229, 1020, 69, 127, 162, 127));
//        int res = numOfSquareArrays(List.of(2,2,2));

      System.out.println(res);
    }
}
