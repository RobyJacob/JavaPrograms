import java.util.*;

public class ThreeSum {
    static List<List<Integer>> threeSum(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();

        Collections.sort(nums);
        for (int i = 0; i < nums.size(); i++) {
            if (i > 0 && Objects.equals(nums.get(i), nums.get(i - 1)))
                continue;

            int j = i + 1;
            int k = nums.size() - 1;

            while (j < k) {
                int sum = nums.get(i) + nums.get(j) + nums.get(k);

                if (sum > 0)
                    k--;
                else if (sum < 0)
                    j++;
                else {
                    res.add(new ArrayList<>(Arrays.asList(nums.get(i), nums.get(j), nums.get(k))));
                    j++;
                    while (j < nums.size() && Objects.equals(nums.get(j), nums.get(j - 1))) j++;
                    k--;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();

        input.add(-1);
        input.add(0);
        input.add(1);
        input.add(2);
        input.add(-1);
        input.add(-4);

        System.out.println(threeSum(input));
    }
}
