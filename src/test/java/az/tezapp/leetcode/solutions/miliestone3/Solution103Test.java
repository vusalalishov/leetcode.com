package az.tezapp.leetcode.solutions.miliestone3;

import az.tezapp.leetcode.solutions.TreeNode;
import az.tezapp.leetcode.solutions.milestone3.Solution103;
import org.junit.jupiter.api.Test;

class Solution103Test {

    private Solution103 subject = new Solution103();

    @Test
    void testZigzagLevelOrder() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.left.left = new TreeNode(15);
        treeNode.left.right = new TreeNode(25);
        treeNode.right.right = new TreeNode(7);
        System.out.println(subject.zigzagLevelOrder(treeNode));
    }

}
