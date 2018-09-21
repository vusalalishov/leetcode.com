package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Solution80Test {

    private Solution80 subject = new Solution80();

    @Test
    void testRemoveDuplicates() {
        int[] nums = new int[] { 0, 0, 1, 1, 1, 1, 2, 2, 2, 4 };
        System.out.println(Arrays.toString(nums));
        System.out.println(subject.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

}
