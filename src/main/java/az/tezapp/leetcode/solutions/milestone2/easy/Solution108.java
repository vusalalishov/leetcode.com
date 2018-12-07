package az.tezapp.leetcode.solutions.milestone2.easy;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution108 {

    // ACCEPTED - 50%
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(0, nums.length, nums);
    }

    private TreeNode buildTree(int from, int to, int[] data) {

        if (from == to) {
            return null;
        }

        int middle = (from + to) / 2;
        TreeNode treeNode = new TreeNode(data[middle]);
        treeNode.left = buildTree(from, middle, data);
        treeNode.right = buildTree(middle + 1, to, data);

        return treeNode;
    }

}
