import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Subsets {
    static List<List<Integer>> subsets(List<Integer> arr) {
        List<List<Integer>> res = new ArrayList<>();

        Collections.sort(arr);

        subsetHelper(arr, 0, arr.size(), res, new ArrayList<>());

        return res;
    }

    private static void subsetHelper(List<Integer> arr, int idx, int size, List<List<Integer>> res,
                                     List<Integer> tmp) {
        if (idx == size) {
            List<Integer> tmpArr = new ArrayList<>();
            for (int i = 0; i < tmp.size(); i++) {
                if (tmp.get(i) == 1)
                    tmpArr.add(arr.get(i));
            }
            res.add(tmpArr);
            return;
        }

        tmp.add(0);
        subsetHelper(arr, idx + 1, size, res, tmp);
        tmp.remove(tmp.size() - 1);
        tmp.add(1);
        subsetHelper(arr, idx + 1, size, res, tmp);
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args){
        List<List<Integer>> res = subsets(new ArrayList<>(List.of(1, 2, 3)));

        res.subList(1, res.size()).sort(Comparator.comparingInt(l -> l.get(0)));

        System.out.println(res);
    }
}
