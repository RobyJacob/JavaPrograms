import java.util.concurrent.atomic.AtomicInteger;

public class OptimisticLocking {
    static  AtomicInteger i = new AtomicInteger();

    static boolean cas(int oldVal, int newVal) {
        return i.compareAndSet(oldVal, newVal);
    }

    static void setVal() {
        if (!cas(0, 10))
            System.out.println(Thread.currentThread().getName() +
                    " could not set value because expected current value is different: " +
                    i.get());
        else
            System.out.println("New value is: " + i.get());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(OptimisticLocking::setVal);
        Thread thread2 = new Thread(OptimisticLocking::setVal);

        thread1.start();
        thread2.start();
    }
}
