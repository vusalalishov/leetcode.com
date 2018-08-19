package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.List;

import az.tezapp.leetcode.solutions.ListNode;

public class Solution61 {

    // ACCEPTED - 19% [TODO: optimize]
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }

        List<Integer> source = new ArrayList<>();
        ListNode pointer = head;
        int len = 0;
        while (pointer != null) {
            source.add(pointer.val);
            pointer = pointer.next;
            len++;
        }
        List<Integer> target = new ArrayList<>(source);
        int jump = k % len;
        for (int i = 0; i < len; i++) {
            target.set((i + jump) % len, source.get(i));
        }

        ListNode output = head;
        output.val = target.get(0);
        output = output.next;
        int i = 1;
        while (output != null) {
            output.val = target.get(i);
            output = output.next;
            i++;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution61 sol = new Solution61();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        l1.next.next.next.next.next.next = new ListNode(7);
        l1.next.next.next.next.next.next.next = new ListNode(8);
        System.out.println(l1);
//        System.out.println(sol.rotateRight(l1, 14));
        System.out.println(sol.rotateRight(l1, 2000001));
    }

}
