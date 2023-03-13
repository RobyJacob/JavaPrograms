import java.util.function.BiFunction;

public class Closure {
    public static void main(String[] args) {
        final int[] init = {10};
        int delta = 2;

        BiFunction<Integer, Integer, Integer> counter = (a, b) -> {
            a += b;
            return a;
        };

        System.out.println(counter.apply(init[0], delta));
    }
}
