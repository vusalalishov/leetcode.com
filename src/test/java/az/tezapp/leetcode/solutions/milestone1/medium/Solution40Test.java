package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.List;

import org.junit.jupiter.api.Test;

class Solution40Test {

    private Solution40 subject = new Solution40();

    @Test
    void testCombinationSum2() {
        List<List<Integer>> lists = subject.combinationSum2(new int[]{
                10,1,2,7,6,1,5
        }, 8);
    }

}
