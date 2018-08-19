package az.tezapp.leetcode.solutions.milestone1.medium;

import az.tezapp.leetcode.solutions.ListNode;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = solution.addTwoNumbers(l1, l2);

        System.out.println(listNode.toString());
    }

    // 48%
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = new ListNode(0);
        ListNode tmpOut = out;

        int additional = 0;
        while (l1 != null || l2 != null) {
            int tmp1 = l1 == null ? 0 : l1.val;
            int tmp2 = l2 == null ? 0 : l2.val;
            int sum = tmp1 + tmp2 + additional;

            tmpOut.val = sum % 10;
            additional = sum / 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            if (l1 != null || l2 != null) {
                tmpOut.next = new ListNode(0);
                tmpOut = tmpOut.next;
            }
        }

        if (additional != 0) {
            tmpOut.next = new ListNode(additional);
        }

        return out;

    }

}

