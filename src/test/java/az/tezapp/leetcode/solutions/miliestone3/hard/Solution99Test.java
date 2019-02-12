package az.tezapp.leetcode.solutions.miliestone3.hard;

import az.tezapp.leetcode.solutions.TreeNode;
import az.tezapp.leetcode.solutions.milestone3.hard.Solution99;
import org.junit.jupiter.api.Test;

class Solution99Test {

    private Solution99 subject = new Solution99();

    @Test
    void test() {
        TreeNode treeNode = TreeNode.of(new Integer[]{2,3,1});
        subject.recoverTree(treeNode);
    }

}
