package az.tezapp.leetcode.solutions.milestone2.medium;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution98 {

    // ACCEPTED - 50% [todo: avoid using recursion]
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidTree(root, null, null);
    }

    private boolean isValidTree(TreeNode node, Integer minValue, Integer maxValue) {
        int val = node.val;
        if (minValue != null && val <= minValue) {
            return false;
        }
        if (maxValue != null && val >= maxValue) {
            return false;
        }
        if ((node.left == null && node.right == null)) {
            return true;
        }
        boolean b = true;
        if (node.left != null) {
            b &= isValidTree(node.left, minValue, val);
        }
        if (b && node.right != null) {
            return isValidTree(node.right, val, maxValue);
        }
        return b;
    }

}
