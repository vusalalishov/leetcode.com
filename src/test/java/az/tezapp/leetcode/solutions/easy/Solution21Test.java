package az.tezapp.leetcode.solutions.easy;

import az.tezapp.leetcode.solutions.ListNode;
import az.tezapp.leetcode.solutions.milestone1.easy.Solution21;
import org.junit.jupiter.api.Test;

class Solution21Test {

    private Solution21 subject = new Solution21();

    @Test
    void testMergeTwoLists() {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = subject.mergeTwoLists(l1, l2);

        System.out.println(listNode);

    }

}
