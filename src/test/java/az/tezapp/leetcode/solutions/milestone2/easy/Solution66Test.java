package az.tezapp.leetcode.solutions.milestone2.easy;

import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution66Test {

    private Solution66 subject = new Solution66();

    @Test
    void testPlusOne() {
        assertThat(subject.plusOne(new int[] {1, 2, 3})).containsExactly(1, 2, 4);
        assertThat(subject.plusOne(new int[] {1, 2, 9})).containsExactly(1, 3, 0);
        assertThat(subject.plusOne(new int[] {9, 9, 9})).containsExactly(1, 0, 0, 0);
    }

}
