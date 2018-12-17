package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.LinkedList;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution129 {

    // ACCEPTED: 30%
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Integer> queueVals = new LinkedList<>();
        LinkedList<TreeNode> queueNodes = new LinkedList<>();
        queueNodes.addFirst(root);
        queueVals.addFirst(0);
        int sum = 0;
        while (!queueNodes.isEmpty()) {
            TreeNode node = queueNodes.removeLast();
            int val = queueVals.removeLast();
            if (node.left != null) {
                queueNodes.addFirst(node.left);
                queueVals.addFirst(val * 10 + node.val);
            }
            if (node.right != null) {
                queueNodes.addFirst(node.right);
                queueVals.addFirst(val * 10 + node.val);
            }
            if (node.left == null && node.right == null) {
                sum += val * 10 + node.val;
            }
        }
        return sum;
    }

}
