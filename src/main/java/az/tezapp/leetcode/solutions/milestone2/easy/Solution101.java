package az.tezapp.leetcode.solutions.milestone2.easy;

import java.util.LinkedList;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution101 {

    // ACCEPTED - 34%
    public boolean isSymmetricNonRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack1.addFirst(root.left);
        stack2.addFirst(root.right);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.removeFirst();
            TreeNode node2 = stack2.removeFirst();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            stack1.addFirst(node1.left);
            stack1.addFirst(node1.right);
            stack2.addFirst(node2.right);
            stack2.addFirst(node2.left);
        }
        return true;
    }

    // ACCEPTED - 6%
    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

}
