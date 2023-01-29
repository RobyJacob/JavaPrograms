import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Combinations {
    static List<List<Integer>> combinations(int a, int b) {
        List<List<Integer>> res = new ArrayList<>();

        combinationsHelper(a, b, res, 1, new ArrayList<>());

        res.sort(Comparator.comparingInt(l -> l.get(0)));

        return res;
    }

    private static void combinationsHelper(int range, int limit, List<List<Integer>> res, int idx,
                                           ArrayList<Integer> tmp) {
        if (limit == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        if (idx > range) return;

        combinationsHelper(range, limit, res, idx + 1, tmp);
        tmp.add(idx);
        combinationsHelper(range, limit - 1, res, idx + 1, tmp);
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args){
      List<List<Integer>> res = combinations(4, 2);

      System.out.println(res);
    }
}
