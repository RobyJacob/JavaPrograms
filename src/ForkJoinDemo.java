import java.util.ArrayList;

public class ForkJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        new ForkJoinJob(4).run();
    }

    static class ForkJoinJob {
        ArrayList<Thread> threads;
        int i = 0;

        ForkJoinJob(int threadCount) {
            threads = new ArrayList<>(threadCount);
        }

        private synchronized void print() {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            i++;
        }

        public void run() throws InterruptedException {
            while (i < 10) {
                print();
            }

            for (int j = 0; j < 4; j++) {
                threads.add(new Thread(() -> {
                    while (i < 40) {
                        print();
                    }
                }));
            }

            threads.forEach(Thread::start);
            for (Thread thread : threads) {
                thread.join();
            }

            while (i < 100) {
                print();
            }
        }
    }
}
