package az.tezapp.leetcode.solutions.milestone2.easy;

import az.tezapp.leetcode.solutions.ListNode;

public class Solution83 {

    // ACCEPTED - 25%
    public ListNode deleteDuplicates(ListNode head) {

        ListNode pointer = head;
        while (pointer != null && pointer.next != null) {
            if (pointer.val == pointer.next.val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }

        return head;
    }

}
