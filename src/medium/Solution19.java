package medium;

public class Solution19 {

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);

        Solution19 solution = new Solution19();
        System.out.println(solution.removeNthFromEnd(ln, 1));

    }

    // 16ms - 67% - not bad
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = null;
        ListNode end = head;
        int distance = 1;
        while (distance++ < n) {
            end = end.next;
        }
        while (end != null && end.next != null) {
            end = end.next;
            if (start == null) {
                start = head;
            } else {
                start = start.next;
            }
        }
        if (start == null) {
            return head.next;
        } else {
            start.next = start.next.next;
        }
        return head;
    }

}
