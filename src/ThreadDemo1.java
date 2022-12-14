import java.util.ArrayList;

public class ThreadDemo1 {
    public static void main(String[] args) {
        Runnable printThreadName = () -> {
          for (int i = 0; i < 5; i++) {
              System.out.println("count: " + i + " " + Thread.currentThread().getName());
          }
        };

        var threadList = new ArrayList<Thread>(20);

        for (int i = 0; i < 20; i++) {
            threadList.add(new Thread(printThreadName));
        }

        threadList.forEach(Thread::start);
    }
}
