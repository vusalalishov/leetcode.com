package az.tezapp.leetcode.solutions.milestone2.medium;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution114 {

    // ACCEPTED - 20%
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode flatLeft = root.left;
        TreeNode flatRight = root.right;
        if (flatLeft != null) {
            root.right = flatLeft;
            while (flatLeft.right != null) {
                flatLeft = flatLeft.right;
            }
            flatLeft.right = flatRight;
            root.left = null;
        }
    }

}
