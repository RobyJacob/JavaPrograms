import java.util.ArrayList;
import java.util.List;

public class BinaryGenerator {
    static List<List<Integer>> generate(Integer n) {
        List<List<Integer>> res = new ArrayList<>();

        generateHelper(n, res, new ArrayList<>(), 0);

        return res;
    }

    private static void generateHelper(Integer n, List<List<Integer>> res, ArrayList<Integer> tmp, int idx) {
        if (idx == n) {
            List<Integer> tmpArr = (List<Integer>) tmp.clone();
            res.add(tmpArr);
            return;
        }

        tmp.add(0);
        generateHelper(n, res, tmp, idx + 1);
        tmp.remove(tmp.size() - 1);
        tmp.add(1);
        generateHelper(n, res, tmp, idx + 1);
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args){
      List<List<Integer>> res = generate(3);

      System.out.println(res);
    }
}
