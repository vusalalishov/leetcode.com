package az.tezapp.leetcode.solutions.milestone2.hard;

import java.util.HashMap;
import java.util.LinkedList;

// TODO: implement custom queue using LinkedList and Set
public class LRUCache {

    private final LinkedList<Integer> queue;
    private final HashMap<Integer, Integer> cache;
    private int length = 0;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        queue = new LinkedList<>();
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        queue.remove((Integer) key);
        queue.addFirst(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (length + 1 > capacity) {
                int keyRemoved = queue.removeLast();
                cache.remove(keyRemoved);
                length--;
            }
            length++;
        }

        cache.put(key, value);
        queue.remove((Integer) key);
        queue.addFirst(key);
    }

}
