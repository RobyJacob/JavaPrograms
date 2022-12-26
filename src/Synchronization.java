public class Synchronization {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    static void syncWait1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " start1");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
            System.out.println(Thread.currentThread().getName() + " end1");
        }
    }

    static void syncWait2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " start2");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
            System.out.println(Thread.currentThread().getName() + " end2");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(Synchronization::syncWait1);
        Thread t2 = new Thread(Synchronization::syncWait2);

        t1.start();
        t2.start();
    }
}
