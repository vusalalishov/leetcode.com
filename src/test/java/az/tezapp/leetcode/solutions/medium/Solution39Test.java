package az.tezapp.leetcode.solutions.medium;

import java.util.List;

import az.tezapp.leetcode.solutions.milestone1.medium.Solution39;
import org.junit.jupiter.api.Test;

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
