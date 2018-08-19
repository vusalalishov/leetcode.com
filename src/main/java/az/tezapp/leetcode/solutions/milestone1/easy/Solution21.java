package az.tezapp.leetcode.solutions.milestone1.easy;

import az.tezapp.leetcode.solutions.ListNode;

public class Solution21 {

    // 95% - ACCEPTED
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode root = l1.val < l2.val ? l1 : l2;
        ListNode mergePointer = l1 == root ? l2 : l1;
        while (mergePointer != null) {
            ListNode rootPointer = root;
            while (rootPointer != null) {
                if (rootPointer.next == null) {
                    rootPointer.next = new ListNode(mergePointer.val);
                    break;
                }
                if (rootPointer.next.val > mergePointer.val) {
                    ListNode toInsert = new ListNode(mergePointer.val);
                    toInsert.next = rootPointer.next;
                    rootPointer.next = toInsert;
                    break;
                } else {
                    rootPointer = rootPointer.next;
                }
            }
            mergePointer = mergePointer.next;
        }
        return root;
    }

}
