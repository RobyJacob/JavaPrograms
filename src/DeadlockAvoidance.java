import java.util.ArrayList;
import java.util.Random;

public class DeadlockAvoidance {
    static void allocateResource() throws InterruptedException {
        while (true) {
            Integer res1 = new Random().nextInt(1, 4);
            Integer res2 = new Random().nextInt(1, 4);

            if (res1 == res2) continue;

            if (res2 < res1) {
                Integer tmp = res2;
                res2 = res1;
                res1 = tmp;
            }

            String threadName = Thread.currentThread().getName();

            System.out.println("res1=" + res1);
            System.out.println("res2=" + res2);
            System.out.println(threadName + " requesting lock on res1" + res1);

            synchronized (res1) {
                System.out.println(threadName + " acquired lock on res1" + res1);
                Thread.sleep(2000);
                System.out.println(threadName + " released lock on res1" + res1);

                System.out.println(threadName + " requesting lock on res2" + res2);
                synchronized (res2) {

                    System.out.println(threadName + " acquired lock on res2" + res2);
                    Thread.sleep(2000);
                    System.out.println(threadName + " released lock on res2" + res2);
                }
            }

            System.out.println(threadName + " completed processing ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<Thread>(6);

        for (int i = 0; i < 6; i++) {
            threads.add(new Thread(() -> {
                try {
                    allocateResource();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        }

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
