public class CombinatoricsModPrime {
    static long fact(long num, long mod) {
        long[] fact = new long[(int) num + 1];

        fact[0] = 1;
        if (fact.length > 1)
            fact[1] = 1;

        for (int i = 2; i <= num; i++) {
            fact[i] = (i * fact[i - 1]) % mod;
        }

        return fact[(int) num];
    }

    static long pow(long a, long b, long mod) {
        long ans = 1;

        while (b > 0) {
            if (b % 2 != 0)
                ans = (ans * a) % mod;
            a = (a % mod * a % mod) % mod;
            b = b/2;
        }

        return ans % mod;
    }

    /*
    Given three integers A, B, and C, where A represents n, B represents r,
    and C represents p and p is a prime number greater than equal to n,
    find and return the value of nCr % p
    Eg:-
        Input
            A = 6
            B = 2
            C = 13
        Output 2
     */
    static long solve(long A, long B, long C) {
        return (fact(A, C) % C *
                pow(fact(A - B, C), C - 2, C) % C *
                pow(fact(B, C), C - 2, C) % C) % C;
    }

    public static void main(String[] args) {
        long result = solve(6, 2, 13);

        System.out.println(result);
    }
}
