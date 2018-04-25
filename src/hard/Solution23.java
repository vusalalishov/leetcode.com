package hard;

import java.util.Arrays;
import java.util.Comparator;

public class Solution23 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(0);

        Solution23 solution = new Solution23();
        System.out.println(solution.mergeKLists3(new ListNode[] {
                n4, n5
        }));
    }

    // TODO: divide and conquer


    public ListNode mergeKLists3(ListNode[] lists) {
        return mergeList(lists, 0, lists.length);
    }

    private ListNode mergeList(ListNode[] lists, int from, int to) {

        if (from + 2 < to) {
            return merge(merge(lists[from], lists[from + 1]), mergeList(lists, from + 2, to));
        }
        if (from + 1 < to) {
            return merge(lists[from], lists[from + 1]);
        }
        if (from < to) {
            return lists[from];
        }

        return null;
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) {
            return n1 == null ? n2 : n1;
        }
        ListNode n3;
        if (n1.val <= n2.val) {
            n3 = new ListNode(n1.val);
            n1 = n1.next;
        } else {
            n3 = new ListNode(n2.val);
            n2 = n2.next;
        }
        ListNode n3Pointer = n3;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                n3Pointer.next = new ListNode(n1.val);
                n1 = n1.next;
            } else {
                n3Pointer.next = new ListNode(n2.val);
                n2 = n2.next;
            }
            n3Pointer = n3Pointer.next;
        }
        ListNode notEmptyNode = n1 == null ? n2 : n1;
        while (notEmptyNode != null) {
            n3Pointer.next = new ListNode(notEmptyNode.val);
            notEmptyNode = notEmptyNode.next;
            n3Pointer = n3Pointer.next;
        }
        return n3;
    }

    // 118 ms
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        Arrays.sort(lists, Comparator.nullsFirst(Comparator.comparingInt(o -> o.val)));

        int startPointer = 0;
        while (startPointer < lists.length && lists[startPointer] == null) {
            startPointer++;
        }

        if (startPointer == lists.length) {
            return null;
        }

        ListNode sorted = null;
        ListNode sortedPointer = null;

        while (true) {
            int minValue = 0;
            boolean minValueAssigned = false;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (!minValueAssigned) {
                        minValue = lists[i].val;
                        minValueAssigned = true;
                    }
                    if (lists[i].val == minValue) {
                        if (sorted == null) {
                            sorted = new ListNode(lists[i].val);
                            sortedPointer = sorted;
                        } else {
                            sortedPointer.next = new ListNode(lists[i].val);
                            sortedPointer = sortedPointer.next;
                        }
                        lists[i] = lists[i].next;
                    }
                }
            }
            if (!minValueAssigned) {
                break;
            } else {
                Arrays.sort(lists, Comparator.nullsFirst(Comparator.comparingInt(o -> o.val)));
            }
        }

        return sorted;

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
