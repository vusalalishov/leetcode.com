package az.tezapp.leetcode.solutions.milestone3.medium;

import java.util.HashMap;
import java.util.Map;

import az.tezapp.leetcode.solutions.Node;

public class Solution138 {

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n2 = new Node(2, null, null);
        Node n3 = new Node(3, null, null);
        Node n4 = new Node(4, null, null);
        Node n5 = new Node(5, null, null);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        n5.random = n1;
        n1.random = n5;
        n2.random = n4;

        Node node = new Solution138().copyRandomList(n1);
    }

    // ACCEPTED - 72.71% - TODO: optimize it
    public Node copyRandomList(Node head) {

        Map<Node, Node> oldToNewMap = new HashMap<>();

        Node h = new Node();
        Node lastNode = h;
        Node loop = head;
        while (loop != null) {
            Node n = oldToNewMap.putIfAbsent(loop, new Node(loop.val, null, null));
            if (n == null) {
                n = oldToNewMap.get(loop);
            }
            if (loop.random != null) {
                oldToNewMap.putIfAbsent(loop.random, new Node(loop.random.val, null, null));
                n.random = oldToNewMap.get(loop.random);
            }
            lastNode.next = n;
            lastNode = n;
            loop = loop.next;
        }

        return h.next;
    }


}
