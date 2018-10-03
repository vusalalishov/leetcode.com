package az.tezapp.leetcode.solutions.milestone2.medium;

import az.tezapp.leetcode.solutions.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution98Test {

    private Solution98 subject = new Solution98();

    @Test
    void testIsValidBST() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        assertThat(subject.isValidBST(root)).isTrue();
    }

    @Test
    void testIsValidBSTCase1() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        assertThat(subject.isValidBST(root)).isTrue();
    }

    @Test
    void testIsValidBSTCase2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        assertThat(subject.isValidBST(root)).isFalse();
    }

}
