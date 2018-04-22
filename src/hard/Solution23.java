package hard;

import java.util.Arrays;
import java.util.Comparator;

public class Solution23 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);

        ListNode n2 = new ListNode(0);

        Solution23 solution = new Solution23();
        System.out.println(solution.mergeKLists(new ListNode[] {
                n1, n2
        }));
    }

    // 195ms - Bad!
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        Arrays.sort(lists, Comparator.nullsFirst(Comparator.comparingInt(o -> o.val)));

        int j = 0;
        while (j < lists.length && lists[j] == null) {
            j++;
        }
        if (j == lists.length) {
            return null;
        }
        ListNode sorted = lists[j];

        for (int i = 0; i < lists.length; i++) {

            if (i == j) {
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
