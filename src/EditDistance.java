public class EditDistance {
    static int minDistance(String w1, String w2, int i, int j, int[][] mem) {
        if (w1.isEmpty() && w2.isEmpty())
            return 0;
        if (i >= w1.length())
            return w2.length() - j;
        if (j >= w2.length())
            return w1.length() - i;
        if (mem[i][j] != -1)
            return mem[i][j];
        if (w1.charAt(i) == w2.charAt(j)) {
            return mem[i][j] = minDistance(w1, w2, i + 1, j + 1, mem);
        }

        int in = minDistance(w1, w2, i, j + 1, mem);
        int del = minDistance(w1, w2, i + 1, j, mem);
        int rep = minDistance(w1, w2, i + 1, j + 1, mem);

        return mem[i][j] = 1 + Math.min(Math.min(in, del), rep);
    }

    public static void main(String[] args) {
        String w1 = "intention";
        String w2 = "execution";
        int n = w1.length();
        int m = w2.length();

        int[][] mem = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mem[i][j] = -1;
            }
        }

        int minOperation = minDistance(w1, w2, 0, 0, mem);

        System.out.println(minOperation);
    }
}
