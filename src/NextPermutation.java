import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    static void replace(List<Integer> list, int start, int end) {
        while (end - start > 0) {
            Collections.swap(list, start, end);
            start++;
            end--;
        }
    }

    static void nextPermutation(List<Integer> list) {
        int n = list.size(), pivotIdx = n - 2;

        while (pivotIdx >= 0 && list.get(pivotIdx) >= list.get(pivotIdx + 1))
            pivotIdx--;

        if (pivotIdx >= 0) {
            int i = pivotIdx + 1;
            while (i <= n - 1 && list.get(i) > list.get(pivotIdx)) i++;
            Collections.swap(list, --i, pivotIdx);
        }

        replace(list, pivotIdx + 1, n - 1);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,1);

        nextPermutation(list);

        System.out.println(list);
    }
}
