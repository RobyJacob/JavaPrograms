import java.util.ArrayList;

public class CombinatoricsModM {
    /*
    Given three integers A, B, and C, where A represents n, B represents r,
    and C represents m, find and return the value of nCr % m
    Eg:-
        Input
            A = 5
            B = 2
            C = 13
        Output 10
     */
    static int solve(int A, int B, int C) {
        ArrayList<ArrayList<Integer>> ncr = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j <= B; j++) {
                if (j == 0 || i == j)
                    arr.add(1);
                else
                    arr.add(0);
            }
            ncr.add(arr);
        }

        for (int i = 2; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                ncr.get(i).set(j, (ncr.get(i - 1).get(j) + ncr.get(i - 1).get(j - 1)) % C);
            }
        }

        return ncr.get(A).get(B);
    }

    public static void main(String[] args) {
        int result = solve(5, 3, 13);

        System.out.println(result);
    }
}
