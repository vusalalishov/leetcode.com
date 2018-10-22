package az.tezapp.leetcode.solutions.milestone2.medium;

import az.tezapp.leetcode.solutions.ListNode;

public class Solution82 {

    // ACCEPTED - 75%
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = null;
        ListNode globalPointer = null;

        while (head != null) {
            boolean skipped = false;
            while (head.next != null && head.val == head.next.val) {
                skipped = true;
                head = head.next;
            }
            if (!skipped) {
                if (pointer == null) {
                    pointer = head;
                    globalPointer = pointer;
                } else {
                    pointer.next = head;
                    pointer = pointer.next;
                }
            }
            head = head.next;
        }
        if (pointer != null) {
            pointer.next = null;
        }

        return globalPointer;
    }

    public static void main(String[] args) {
        Solution82 solution = new Solution82();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        System.out.println(solution.deleteDuplicates(node));
    }

}
