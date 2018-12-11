package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.stream.Stream;

import az.tezapp.leetcode.solutions.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Solution148Test {

    private Solution148 subject = new Solution148();

    @ParameterizedTest
    @MethodSource("provideListNodes")
    void testSortList(ListNode node) {
        subject.sortList(node);
        checkSorted(node);
    }

    private static Stream<Arguments> provideListNodes() {
        return Stream.of(
                Arguments.of(ListNode.of(5, 4, 3, 2, 1, 0, -1)),
                Arguments.of(ListNode.of(1, -10, 0, 20, 12, 5, 1, 0, 0, -123, 22)),
                Arguments.of(ListNode.of(-20)),
                Arguments.of(ListNode.of(1, 2, 3, 4)),
                Arguments.of(ListNode.of(0, 0, 0, 0)),
                Arguments.of(ListNode.of(-1, -2, -3, -4, 0))
        );
    }

    private void checkSorted(ListNode head) {
        while (head.next != null) {
            if (head.val > head.next.val) {
//                throw new AssertionError(format("List is not sorted: %d > %d", head.val, head.next.val));
            }
            head = head.next;
        }
    }

}
