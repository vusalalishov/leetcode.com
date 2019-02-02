package az.tezapp.leetcode.solutions.milestone3.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution107 {

    // ACCEPTED - 97%
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<List<Integer>> lists = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> tmpQueue = new LinkedList<>();
            List<Integer> items = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode item = queue.removeLast();
                items.add(item.val);
                if (item.left != null) {
                    tmpQueue.addFirst(item.left);
                }
                if (item.right != null) {
                    tmpQueue.addFirst(item.right);
                }
            }
            lists.addFirst(items);
            queue = tmpQueue;
        }

        return lists;
    }

}
