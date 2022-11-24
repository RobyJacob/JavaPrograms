import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LruCache {
    private Integer capacity;
    private Map<Integer, Integer> cache;
    private Deque<Integer> queue;

    public LruCache(Integer capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        queue = new LinkedList<>();
    }

    public Integer get(Integer key) {
        if (cache.containsKey(key)) {
            queue.remove(key);
            queue.addLast(key);
        }

        return cache.getOrDefault(key, -1);
    }

    public void set(Integer key, Integer val) {
        if (cache.containsKey(key)) {
            queue.remove(key);
        } else {
            if (queue.size() >= capacity) {
                cache.remove(queue.removeFirst());
            }
        }

        queue.addLast(key);
        cache.put(key, val);
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(3);

        lruCache.set(1, 10);
        lruCache.set(5, 50);
        lruCache.set(1, 20);
        System.out.println(lruCache.get(5));
        lruCache.set(6, 60);
        System.out.println(lruCache.get(1));
    }
}
