import java.util.ArrayList;
import java.util.List;

public class PessimisticLocking {
    static int count = 0;

    synchronized static void incr() {
        count++;
    }

    static void run() {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100000; i++) threads.add(new Thread(PessimisticLocking::incr));

        threads.forEach(Thread::start);

        System.out.println(count);
    }

    public static void main(String[] args) {
        run();
    }
}
