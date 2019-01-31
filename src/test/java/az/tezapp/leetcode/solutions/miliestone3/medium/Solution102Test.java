package az.tezapp.leetcode.solutions.miliestone3.medium;

import az.tezapp.leetcode.solutions.TreeNode;
import az.tezapp.leetcode.solutions.milestone3.medium.Solution102;
import org.junit.jupiter.api.Test;

class Solution102Test {

    private Solution102 subject = new Solution102();

    @Test
    void testLevelOrderUsingQueue() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.left.left = new TreeNode(15);
        treeNode.left.right = new TreeNode(7);
        subject.levelOrderUsingQueue(treeNode);
    }

}
