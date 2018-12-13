package az.tezapp.leetcode.solutions.milestone2.easy;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode root, int sum, int pathSum) {
        if (root == null) {
            return false;
        }
        pathSum += root.val;
        if (pathSum == sum && root.left == null && root.right == null) {
            return true;
        }
        return (hasPathSum(root.left, sum, pathSum)) ||
                (hasPathSum(root.right, sum, pathSum));
    }

}
