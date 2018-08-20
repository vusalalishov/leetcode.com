package az.tezapp.leetcode.solutions.milestone2.easy;

import az.tezapp.leetcode.solutions.ListNode;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution83Test {

    private Solution83 subject = new Solution83();

    @Test
    void testDeleteDuplicates() {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(1);
        ln.next.next = new ListNode(2);
        ln.next.next.next = new ListNode(2);
        ln.next.next.next.next = new ListNode(3);
        ln.next.next.next.next.next = new ListNode(4);
        ln.next.next.next.next.next.next = new ListNode(4);
        subject.deleteDuplicates(ln);
        assertThat(ln.toString()).isEqualTo("1 -> 2 -> 3 -> 4");
    }

}
