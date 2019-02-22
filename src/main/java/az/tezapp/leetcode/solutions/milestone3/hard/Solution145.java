package az.tezapp.leetcode.solutions.milestone3.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution145 {

    // ACCEPTED - 60%
    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> out = new ArrayList<>();

        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        LinkedList<Boolean> stack3 = new LinkedList<>();
        stack1.push(root);
        boolean isGoingDown = true;

        while (!stack1.isEmpty()) {

            if (!isGoingDown) {
                TreeNode node = stack2.pop();
                Boolean leaveTree = stack3.pop();
                if (leaveTree) {
                    out.add(node.val);
                } else {
                    stack2.push(node);
                    stack3.push(true);
                    isGoingDown = true;
                }
            } else {

                TreeNode node = stack1.pop();
                if (node.left == null && node.right == null) {
                    out.add(node.val);
                    isGoingDown = false;
                } else {
                    if (node.left != null && node.right != null) {
                        stack3.push(false);
                    } else {
                        stack3.push(true);
                    }
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                    stack2.push(node);
                    isGoingDown = true;
                }
            }
        }

        while (!stack2.isEmpty()) {
            out.add(stack2.pop().val);
        }

        return out;
    }

}
