package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.List;

import az.tezapp.leetcode.solutions.ListNode;

public class Solution143 {

    // ACCEPTED - 19%
    public void reorderList(ListNode head) {

        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            nodes.add(head);
            head = next;
        }

        ListNode node = new ListNode(0);
        int begin = 0;
        int end = nodes.size() - 1;
        while (begin <= end) {
            if (begin == end) {
                node.next = nodes.get(begin);
                break;
            } else {
                node.next = nodes.get(begin);
                node = node.next;
                node.next = nodes.get(end);
                node = node.next;
                begin++;
                end--;
            }
        }

    }

}
