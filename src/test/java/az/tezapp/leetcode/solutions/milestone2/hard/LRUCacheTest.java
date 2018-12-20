package az.tezapp.leetcode.solutions.milestone2.hard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class LRUCacheTest {

    @Test
    void testCache() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void testCacheDoubleGet() {
        LRUCache cache = new LRUCache(2);
        assertEquals(-1, cache.get(2));
        cache.put(2, 6);
        assertEquals(-1, cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        assertEquals(2, cache.get(1));
        assertEquals(6, cache.get(2));
    }

    @Test
    void testCacheComplex() {
        LRUCache cache = new LRUCache(10);
        assertEquals(-1, cache.get(10));
        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        assertEquals(-1, cache.get(13));
        cache.put(2, 19);
        assertEquals(19, cache.get(2));
        assertEquals(17, cache.get(3));
        cache.put(5, 25);
        assertEquals(-1, cache.get(8));
        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        assertEquals(-1, cache.get(11));
        cache.put(9, 12);
        assertEquals(-1, cache.get(7));
        assertEquals(5, cache.get(5));
        assertEquals(-1, cache.get(8));
        assertEquals(12, cache.get(9));
        cache.put(4, 30);
        cache.put(9, 3);
        assertEquals(3, cache.get(9));
        assertEquals(5, cache.get(10));
        assertEquals(5, cache.get(10));
        cache.put(6, 14);
        cache.put(3, 1);
        assertEquals(1, cache.get(3));
        cache.put(10, 11);
        assertEquals(-1, cache.get(8));
        cache.put(2, 14);
        assertEquals(30, cache.get(1));
        assertEquals(5, cache.get(5));
        assertEquals(30, cache.get(4));



        cache.put(1, 2);
        assertEquals(2, cache.get(1));
        assertEquals(14, cache.get(2));
    }

}
