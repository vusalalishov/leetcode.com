package az.tezapp.leetcode.solutions.milestone2.easy;

import java.util.LinkedList;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution100 {

    // ACCEPTED - 15%
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // ACCEPTED - 99%
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pStack = new LinkedList<>();
        LinkedList<TreeNode> qStack = new LinkedList<>();
        pStack.addFirst(p);
        qStack.addFirst(q);
        while (!pStack.isEmpty() || !qStack.isEmpty()) {
            TreeNode pNode = pStack.removeFirst();
            TreeNode qNode = qStack.removeFirst();
            if (pNode == null && qNode == null) {
                continue;
            }
            if (pNode == null || qNode == null) {
                return false;
            }
            if (pNode.val != qNode.val) {
                return false;
            }
            pStack.addFirst(pNode.left);
            pStack.addFirst(pNode.right);
            qStack.addFirst(qNode.left);
            qStack.addFirst(qNode.right);
        }
        return pStack.isEmpty() && qStack.isEmpty();
    }

}
