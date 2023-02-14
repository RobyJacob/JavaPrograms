import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    static List<Integer> grayCode(Integer n) {
        List<Integer> res = new ArrayList<>();

        for (int num = 0; num < Math.floor(Math.pow(2, n)); num++) {
            res.add((num >> 1) ^ num);
        }

        return res;
    }

    public static void main(String[] args){
      List<Integer> grayCodeSequence = grayCode(3);

      System.out.println(grayCodeSequence);
    }
}
