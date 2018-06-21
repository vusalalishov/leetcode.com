package az.tezapp.leetcode.solutions.easy;

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
