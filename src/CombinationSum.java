import java.util.*;

public class CombinationSum {
    static List<List<Integer>> combinationSum(List<Integer> arr, int b) {
        List<List<Integer>> res = new ArrayList<>();

        Collections.sort(arr);

        combinationSumHelper(arr, res, 0, b, new ArrayList<>(), new HashSet<>());

        return res;
    }

    static void combinationSumHelper(List<Integer> arr, List<List<Integer>> res, int idx, int b,
                                     ArrayList<Integer> tmp, Set<ArrayList<Integer>> visited) {
        if (b == 0) {
            if (!visited.contains(tmp)) {
                visited.add(new ArrayList<>(tmp));
                res.add(new ArrayList<>(tmp));
            }
            return;
        }

        if (b < 0) return;

        for (int i = 0; i < arr.size(); i++) {
            tmp.add(arr.get(i));
            if (idx == 0 || (idx > 0 && tmp.get(idx - 1) <= tmp.get(idx)))
                combinationSumHelper(arr, res, idx + 1, b - arr.get(i), tmp, visited);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args){
      List<List<Integer>> res = combinationSum(new ArrayList<>(List.of(8,10,6,11,1,16,8)), 28);

      System.out.println(res);
    }
}
