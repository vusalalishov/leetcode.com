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
        return copy(head, new HashMap<>());
    }

    private Node copy(Node head, Map<Node, Node> oldToNewMap) {
        if (head != null) {
            oldToNewMap.putIfAbsent(head, new Node(head.val, null, null));
            Node n = oldToNewMap.get(head);
            n.next = copy(head.next, oldToNewMap);

            if (head.random != null) {
                oldToNewMap.putIfAbsent(head.random, new Node(head.random.val, null, null));
                n.random = oldToNewMap.get(head.random);
            }
            return n;
        } else {
            return null;
        }
    }


}
