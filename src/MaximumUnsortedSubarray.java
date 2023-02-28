import java.util.ArrayList;
import java.util.List;

public class MaximumUnsortedSubarray {
    static List<Integer> getMaxUnsortedSubArr(List<Integer> arr) {
        int n = arr.size();
        int i = 0, j = n - 1;

        while (i < n - 1 && arr.get(i) <= arr.get(i + 1)) i++;
        while (j > 0 && arr.get(j) >= arr.get(j - 1)) j--;

        if (i == n - 1) return new ArrayList<>(List.of(-1));

        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {
            mn = Math.min(mn, arr.get(k));
            mx = Math.max(mx, arr.get(k));
        }

        int start = 0, end = n - 1;

        while (start <= i && arr.get(start) <= mn) start++;
        while (end >= j && arr.get(end) >= mx) end--;

        return new ArrayList<>(List.of(start, end));
    }

    public static void main(String[] args){
        var res = getMaxUnsortedSubArr(new ArrayList<>(List.of(1, 3, 2, 4, 5)));

        System.out.println(res);
    }
}
