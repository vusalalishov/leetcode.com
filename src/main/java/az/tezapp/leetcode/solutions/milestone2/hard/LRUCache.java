package az.tezapp.leetcode.solutions.milestone2.hard;

import java.util.HashMap;
import java.util.Map;

// ACCEPTED - 12%
public class LRUCache {

    private final LinkedUniqueQueue queue;
    private final HashMap<Integer, Integer> cache;
    private int length = 0;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        queue = new LinkedUniqueQueue();
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        queue.push(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (length + 1 > capacity) {
                int keyRemoved = queue.poll();
                cache.remove(keyRemoved);
                length--;
            }
            length++;
        }

        cache.put(key, value);
        queue.push(key);
    }

    static class LinkedUniqueQueue {

        private ListNode head = null;
        private ListNode tail = null;
        private int size = 0;
        private Map<Integer, ListNode> listNodes = new HashMap<>();

        public void push(int val) {
            if (listNodes.containsKey(val)) {
                ListNode listNode = listNodes.get(val);
                listNodes.remove(val);
                remove(listNode);
                size--;
                if (size == 0) {
                    head = null;
                    tail = null;
                }
                push(val);
                return;
            }
            ListNode node = new ListNode(val);
            node.left = node;
            node.right = node;
            if (size == 0) {
                head = node;
                tail = node;
                tail.left = null;
                listNodes.put(val, head);
            } else {
                node.left = head;
                head.right = node;
                head = node;
                head.right = null;
                listNodes.put(val, head);
            }
            size++;
        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("Queue is empty!");
            }
            int val = tail.val;
            listNodes.remove(val);
            size--;
            if (size == 0) {
                tail = null;
                head = null;
            } else {
                tail = tail.right;
                tail.left = null;
            }
            return val;
        }

        private void remove(ListNode listNode) {
            if (head != null && listNode.val == head.val) {
                head = head.left;
            } else if (tail != null && listNode.val == tail.val) {
                tail = tail.right;
            } else {
                if (listNode.left != null) {
                    listNode.left.right = listNode.right;
                }
                if (listNode.right != null) {
                    listNode.right.left = listNode.left;
                }
            }
        }

    }

    static class ListNode {
        public ListNode right;
        public ListNode left;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
