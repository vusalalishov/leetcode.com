package az.tezapp.leetcode.solutions.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

class Solution39Test {

    private Solution39 subject = new Solution39();

    @Test
    void testCombinationSum() {
        List<List<Integer>> lists = subject.combinationSum(new int[]{
                8, 7, 3, 4
        }, 11);
//        assertThat(lists).hasSize(2);
    }

}
