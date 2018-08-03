package az.tezapp.leetcode.solutions.medium;

public class Solution61 {

    // ACCEPTED - 18% [TODO: optimize]
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }

        int len = findLength(head);

        k = k % len;

        int valueHolder = head.val;
        ListNode mainPointer = head;
        ListNode pointer = mainPointer;

        int moved = 0;
        while (moved < len) {
            int c = k;
            while (c > 0) {
                c--;
                pointer = pointer.next != null ? pointer.next : head;
            }
            int tmpVal = pointer.val;
            pointer.val = valueHolder;
            valueHolder = tmpVal;
            moved++;
            if (pointer == mainPointer) {
                mainPointer = mainPointer.next;
                pointer = mainPointer;
                if (pointer != null) {
                    valueHolder = pointer.val;
                }
            }
        }
        return head;
    }

    private int findLength(ListNode node) {
        int c = 0;
        while (node != null) {
            c++;
            node = node.next;
        }
        return c;
    }

    public static void main(String[] args) {
        Solution61 sol = new Solution61();
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
//        l1.next.next.next.next.next = new ListNode(6);
//        l1.next.next.next.next.next.next = new ListNode(7);
//        l1.next.next.next.next.next.next.next = new ListNode(8);
        System.out.println(l1);
//        System.out.println(sol.rotateRight(l1, 14));
        System.out.println(sol.rotateRight(l1, 1));
    }

}
