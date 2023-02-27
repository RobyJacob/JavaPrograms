import java.util.*;

public class NQueens {
    static ArrayList<ArrayList<String>> nQueenConfig(int n) {
        List<List<String>> configs = new ArrayList<>();

        List<String> config = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            config.add(".".repeat(n));
        }

        nQueenConfigHelper(n, configs, 0, config, n, new HashSet<>());

        ArrayList<ArrayList<String>> board = new ArrayList<>();

        for (List<String> row : configs) {
            board.add((ArrayList<String>) row);
        }

        return board;
    }

    private static void nQueenConfigHelper(int n, List<List<String>> configs, int row,
                                           List<String> config, int queens, Set<List<String>> visited) {
        if (row >= n) {
//            System.out.println(configs);
            if (queens == 0) {
                List<String> board = new ArrayList<>(config);
                if (!visited.contains(board)) {
                    visited.add(board);
                    configs.add(board);
                }
            }
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(n, row, col, config)) {
                StringBuilder builder = new StringBuilder(config.get(row));
                builder.setCharAt(col, 'Q');
                config.set(row, builder.toString());
                nQueenConfigHelper(n, configs, row + 1, config, queens - 1, visited);
                builder.setCharAt(col, '.');
                config.set(row, builder.toString());
            }
        }
    }

    private static boolean isSafe(int n, int row, int col, List<String> board) {
        for (int i = 0; i < n; i++) {
            if ((i != col && board.get(row).charAt(i) == 'Q') ||
                    (i != row && board.get(i).charAt(col) == 'Q')) return false;
        }

        int r = row + 1, c = col + 1;

        while (r < n && c < n) {
            if (board.get(r++).charAt(c++) == 'Q') return false;
        }

        r = row - 1;
        c = col - 1;

        while (r >= 0 && c >= 0) {
            if (board.get(r--).charAt(c--) == 'Q') return false;
        }

        r = row + 1;
        c = col - 1;

        while (r < n && c >= 0) {
            if (board.get(r++).charAt(c--) == 'Q') return false;
        }

        r = row - 1;
        c = col + 1;

        while (r >= 0 && c < n) {
            if (board.get(r--).charAt(c++) == 'Q') return false;
        }

        return true;
    }

    public static void main(String[] args){
        var res = nQueenConfig(1);

        System.out.println(res);
    }
}
