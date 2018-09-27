package az.tezapp.leetcode.solutions.milestone2.medium;

import az.tezapp.leetcode.solutions.ListNode;

public class Solution86 {

    // ACCEPTED - 100%
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headPointer = head;
        ListNode replacer = head.val < x ? head : null;
        if (replacer != null) {
            while (replacer.next != null && replacer.next.val < x) {
                replacer = replacer.next;
            }
        }
        ListNode finder = replacer == null ? head : replacer;
        while (finder.next != null) {
            if (finder.next.val < x) {
                ListNode nodeToMove = finder.next;
                finder.next = finder.next.next;

                if (replacer != null) {
                    nodeToMove.next = replacer.next;
                    replacer.next = nodeToMove;
                    replacer = replacer.next;
                } else {
                    replacer = nodeToMove;
                    replacer.next = head;
                    headPointer = replacer;
                }
            } else {
                finder = finder.next;
            }
        }
        return headPointer;
    }

    public static void main(String[] args) {
        Solution86 solution = new Solution86();
        ListNode node = new ListNode(5);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next = new ListNode(1);
        System.out.println(node);
        System.out.println(solution.partition(node, 3));
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(1);
        System.out.println(node1);
        System.out.println(solution.partition(node1, 3));
    }

}
