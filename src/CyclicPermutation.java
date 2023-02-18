public class CyclicPermutation {
    public static void main(String[] args) {
        String A = "1101111111";
        String B = "1101111111";

        String newB = B + B;
        int result = 0;

        int[] z = GenerateZArray.generate(A, newB);

        for (int i = 1; i < z.length - B.length(); i++) {
            if (z[i] == A.length()) {
                result++;
            }
        }

        System.out.println(result);
    }
}
