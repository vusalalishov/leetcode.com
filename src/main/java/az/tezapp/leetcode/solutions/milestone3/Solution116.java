package az.tezapp.leetcode.solutions.milestone3;

import az.tezapp.TreeLinkNode;

public class Solution116 {

    // ACCEPTED - 17%
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        connect(root.left, root.right);
    }

    private void connect(TreeLinkNode left, TreeLinkNode right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        connect(left.left, left.right);
        connect(right.left, right.right);
        connect(left.right, right.left);
    }

}
