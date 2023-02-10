import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {
    static void merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int m, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && arr1.get(i) > arr2.get(j)) arr1.set(k--, arr1.get(i--));
            else arr1.set(k--, arr2.get(j--));
        }
    }

    public static void main(String[] args){
      ArrayList<Integer> arr1 = new ArrayList<>(List.of(2,7,10,0,0,0,0));
      ArrayList<Integer> arr2 = new ArrayList<>(List.of(5,8,12,13));

      merge(arr1, arr2, 3, 4);

      System.out.println(arr1);
    }
}
