package az.tezapp.leetcode.solutions.easy;

import az.tezapp.leetcode.solutions.milestone1.easy.Solution27;
import org.junit.jupiter.api.Test;

class Solution27Test {

    @Test
    void testRemoveElement() {
        Solution27 solution = new Solution27();
        int[] nums = new int[] {
                1
        };
        int n = solution.removeElement(nums, 1);
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }

}
