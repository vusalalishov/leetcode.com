package az.tezapp.leetcode.solutions.milestone3.medium;

import java.util.LinkedList;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution230 {

    // ACCEPTED - 100%
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        boolean goLeft = true;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && goLeft) {
                stack.push(node);
                stack.push(node.left);
            } else {
                k--;
                if (k == 0) {
                    return node.val;
                }
                goLeft = false;
                if (node.right != null) {
                    goLeft = true;
                    stack.push(node.right);
                }
            }
        }
        throw new RuntimeException("Something went wrong!");
    }

}
