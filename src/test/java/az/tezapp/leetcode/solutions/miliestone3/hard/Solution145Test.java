package az.tezapp.leetcode.solutions.miliestone3.hard;

import java.util.Arrays;

import az.tezapp.leetcode.solutions.TreeNode;
import az.tezapp.leetcode.solutions.milestone3.hard.Solution145;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution145Test {

    private Solution145 subject = new Solution145();

    @Test
    void testPostorderTraversal() {
        TreeNode treeNode = TreeNode.of(new Integer[] {1,5,4,2,null,null,null,3});
        assertThat(subject.postorderTraversal(treeNode)).isEqualTo(Arrays.asList(3,2,5,4,1));
        assertThat(subject.postorderTraversal(TreeNode.of(new Integer[] {1,null,2,null,null,3}))).isEqualTo(Arrays.asList(3,2,1));
        assertThat(subject.postorderTraversal(TreeNode.of(new Integer[] {4,2,null,1,3}))).isEqualTo(Arrays.asList(1,3,2,4));
        assertThat(subject.postorderTraversal(TreeNode.of(new Integer[] {3,2,4,null,null,1}))).isEqualTo(Arrays.asList(2,1,4,3));
    }

}
