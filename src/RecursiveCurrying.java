import java.util.function.Function;

public class RecursiveCurrying {
    static Function<Integer, Function<Integer, Integer>> sum() {
        return a -> b -> {
            if (b == 0) return a;
            return sum().apply(a + b).apply(b - 1);
        };
    }

    public static void main(String[] args) {
        System.out.println(sum().apply(0).apply(3));
    }
}
