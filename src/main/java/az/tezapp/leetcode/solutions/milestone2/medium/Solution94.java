package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution94 {

    // ACCEPTED - Good Job!
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        boolean checkLeft = true;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (checkLeft && node.left != null) {
                stack.push(node.left);
            } else {
                stack.pop();
                result.add(node.val);
                checkLeft = false;
                if (node.right != null) {
                    stack.push(node.right);
                    checkLeft = true;
                }
            }
        }
        return result;
    }

}
