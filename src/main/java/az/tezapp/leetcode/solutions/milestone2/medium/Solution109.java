package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.List;

import az.tezapp.leetcode.solutions.ListNode;
import az.tezapp.leetcode.solutions.TreeNode;

public class Solution109 {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> data = new ArrayList<>();
        while (head != null) {
            data.add(head.val);
            head = head.next;
        }

        return buildTree(0, data.size(), data);
    }

    private TreeNode buildTree(int from, int to, List<Integer> data) {

        if (from == to) {
            return null;
        }

        int middle = (from + to) / 2;
        TreeNode treeNode = new TreeNode(data.get(middle));
        treeNode.left = buildTree(from, middle, data);
        treeNode.right = buildTree(middle + 1, to, data);

        return treeNode;
    }

}
