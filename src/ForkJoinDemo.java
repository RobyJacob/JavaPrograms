import java.util.ArrayList;

public class ForkJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        new ForkJoinJob(4).run();
    }

    static class ForkJoinJob {
        ArrayList<Thread> threads;

        ForkJoinJob(int threadCount) {
            threads = new ArrayList<>(threadCount);
        }

        public void run() throws InterruptedException {
            final int[] i = {0};

            while (i[0] < 10) {
                System.out.println(Thread.currentThread().getName() + " : " + i[0]++);
            }

            for (int j = 0; j < 4; j++) {
                threads.add(new Thread(() -> {
                    while (i[0] < 40) {
                        System.out.println(Thread.currentThread().getName() + " : " + i[0]++);
                    }
                }));
            }

            threads.forEach(Thread::start);
            for (Thread thread : threads) {
                thread.join();
            }

            while (i[0] < 100) {
                System.out.println(Thread.currentThread().getName() + " : " + i[0]++);
            }
        }
    }
}
