package az.tezapp.leetcode.solutions.milestone3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution102 {

    // ACCEPTED - 17%
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> out = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            List<Integer> integers = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode treeNode = stack.pop();
                nodes.add(treeNode);
                integers.add(treeNode.val);
            }
            out.add(integers);
            for (int i = nodes.size() - 1; i >= 0; i--) {
                if (nodes.get(i).right != null) {
                    stack.push(nodes.get(i).right);
                }
                if (nodes.get(i).left != null) {
                    stack.push(nodes.get(i).left);
                }
            }
        }

        return out;
    }

    // ACCEPTED - 77% [TODO: optimization tip: - maybe custom Queue implementation does make a sense]
    public List<List<Integer>> levelOrderUsingQueue(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> out = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        int nodeCountAtTheLevel = 1;
        while (!queue.isEmpty()) {
            int nodeCountAtNextLevel = 0;
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < nodeCountAtTheLevel; i++) {
                TreeNode treeNode = queue.removeLast();
                integers.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.addFirst(treeNode.left);
                    nodeCountAtNextLevel++;
                }
                if (treeNode.right != null) {
                    queue.addFirst(treeNode.right);
                    nodeCountAtNextLevel++;
                }
            }
            nodeCountAtTheLevel = nodeCountAtNextLevel;
            out.add(integers);
        }

        return out;
    }

}
