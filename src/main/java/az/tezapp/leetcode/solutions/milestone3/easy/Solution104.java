package az.tezapp.leetcode.solutions.milestone3.easy;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution104 {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }

}
