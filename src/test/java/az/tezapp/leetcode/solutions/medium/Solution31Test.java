package az.tezapp.leetcode.solutions.medium;

import az.tezapp.leetcode.solutions.milestone1.medium.Solution31;
import org.junit.jupiter.api.Test;

class Solution31Test {

    private Solution31 subject = new Solution31();

    @Test
    void testNextPermutation() {
        int[] n = new int[] {
                3,2,1
        };
        subject.nextPermutation(n);
    }

}
