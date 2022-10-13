import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SumOfTwo {
    static ArrayList<Integer> solve(ArrayList<Integer> arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (!map.containsKey(arr.get(i))) {
                map.put(arr.get(i), i);
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            int val = target - arr.get(i);
            if (map.containsKey(val) && map.get(val) != i) {
                result.add(i);
                result.add(map.get(val));
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(2, 2, 7,11,15)), 9));
    }
}
