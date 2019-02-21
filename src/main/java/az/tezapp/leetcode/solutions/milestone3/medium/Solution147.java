package az.tezapp.leetcode.solutions.milestone3.medium;

import az.tezapp.leetcode.solutions.ListNode;

public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode headPointer = newHead;
        while (headPointer.next != null) {
            ListNode min = null;
            ListNode prev = null;
            ListNode pointer = headPointer;
            while (pointer.next != null) {
                if (min == null) {
                    min = pointer.next;
                    prev = pointer;
                } else {
                    if (pointer.next.val < min.val) {
                        min = pointer.next;
                        prev = pointer;
                    }
                }
                pointer = pointer.next;
            }
            if (min != null) {
                prev.next = prev.next.next;
                min.next = headPointer.next;
                headPointer.next = min;
            }
            headPointer = headPointer.next;
        }

        return newHead.next;
    }

}
