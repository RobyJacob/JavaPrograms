import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyLargePrimeNumberRange {
    static AtomicInteger count = new AtomicInteger(2);

    static AtomicInteger currentNum = new AtomicInteger(3);

    static final Integer MAX_VALUE = 100000000;

    static void countPrimes() {
        while (true) {
            int num = currentNum.incrementAndGet();

            if (num > MAX_VALUE) break;

            boolean flag = false;
            for (int i = 2; i <= Math.floor(Math.sqrt(num)); i++) {
                if (num % i == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                long start = System.currentTimeMillis();
                countPrimes();
                System.out.println(Thread.currentThread().getName() + " completed in " +
                        (System.currentTimeMillis() - start));
            });
        }

        pool.shutdown();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Primes in range(1,%d)=%d%n", MAX_VALUE, count.get());
    }
}
