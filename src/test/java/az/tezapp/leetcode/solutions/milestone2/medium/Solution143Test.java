package az.tezapp.leetcode.solutions.milestone2.medium;

import az.tezapp.leetcode.solutions.ListNode;
import org.junit.jupiter.api.Test;

class Solution143Test {

    private Solution143 subject = new Solution143();

    @Test
    void testReorderList() {
        ListNode node = ListNode.of(1, 2, 3, 4, 5);
        subject.reorderList(node);
        System.out.println(node.toString());
    }

}
