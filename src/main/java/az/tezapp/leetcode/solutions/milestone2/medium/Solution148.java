package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.Arrays;
import java.util.List;

import az.tezapp.leetcode.solutions.ListNode;

public class Solution148 {

    // ACCEPTED - 12%
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return mergeSort(head);
    }


    public ListNode merge(ListNode node1, ListNode node2) {

        ListNode extraNode = new ListNode(Integer.MIN_VALUE);
        ListNode extraNodePointer = extraNode;

        while (node1 != null && node2 != null) {
            int v1 = node1.val;
            int v2 = node2.val;
            if (v1 <= v2) {
                extraNodePointer.next = node1;
                node1 = node1.next;
            } else {
                extraNodePointer.next = node2;
                node2 = node2.next;
            }
            extraNodePointer = extraNodePointer.next;
        }

        extraNodePointer.next = node1 == null ? node2 : node1;

        return extraNode.next;
    }

    public ListNode mergeSort(ListNode node) {
        if (node.next == null) {
            return node;
        }
        List<ListNode> split = split(node);
        return merge(mergeSort(split.get(0)), mergeSort(split.get(1)));
    }

    private List<ListNode> split(ListNode head) {
        ListNode middle = null;
        ListNode last = head.next;
        while (last != null) {
            last = last.next;
            if (last != null) {
                last = last.next;
            }
            if (middle == null) {
                middle = head;
            } else {
                middle = middle.next;
            }
        }
        ListNode right = middle.next;
        middle.next = null;
        return Arrays.asList(head, right);
    }

}
