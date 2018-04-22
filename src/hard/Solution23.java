package hard;

import java.util.Arrays;
import java.util.Comparator;

public class Solution23 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);

        ListNode n2 = new ListNode(0);

        Solution23 solution = new Solution23();
        System.out.println(solution.mergeKLists(new ListNode[] {
                null, null
        }));
    }

    // 195ms - Bad!
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        int pIndex = 0;
        while (pIndex < lists.length && lists[pIndex] == null) {
            pIndex++;
        }

        if (pIndex == lists.length) {
            return null;
        }

        int min = lists[pIndex].val;
        int minIndex = pIndex;
        int minPointer = pIndex + 1;
        while (minPointer < lists.length) {
            if (lists[minPointer] != null && lists[minPointer].val < min) {
                min = lists[minPointer].val;
                minIndex = minPointer;
            }
            minPointer++;
        }

        ListNode sorted = lists[minIndex];

        for (int i = 0; i < lists.length; i++) {

            if (i == minIndex) {
                continue;
            }

            ListNode sourcePointer = lists[i];
            while (sourcePointer != null) {
                int val = sourcePointer.val;
                ListNode sortedPointer = sorted;
                while (sortedPointer.next != null && sortedPointer.next.val <= val) {
                    sortedPointer = sortedPointer.next;
                }
                if (sortedPointer.next == null) {
                    sortedPointer.next = new ListNode(val);
                } else {
                    ListNode tmp = new ListNode(val);
                    tmp.next = sortedPointer.next;
                    sortedPointer.next = tmp;
                }
                sourcePointer = sourcePointer.next;
            }
        }

        return sorted;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(val);
        ListNode tmp = this;
        while (tmp.next != null) {
            tmp = tmp.next;
            out.append(" -> ");
            out.append(tmp.val);
        }
        return out.toString();
    }
}
