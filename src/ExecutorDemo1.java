import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            executor.execute(() -> {
                int sum = 0;
                for (int j = 0; j < 10; j++) {
                    System.out.println("sum: " + ++sum + " " + Thread.currentThread().getName());
                }
            });
        }

        executor.shutdown();
    }
}
