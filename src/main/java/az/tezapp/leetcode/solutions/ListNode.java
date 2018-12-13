package az.tezapp.leetcode.solutions;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
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

    public static ListNode of(int... items) {
        ListNode head = new ListNode(items[0]);
        ListNode pointer = head;
        for (int i = 1; i < items.length; i++) {
            pointer.next = new ListNode(items[i]);
            pointer = pointer.next;
        }
        return head;
    }

}
