package az.tezapp.leetcode.solutions.milestone2.hard;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution128Test {

    private Solution128 subject = new Solution128();

    @Test
    void testLongestConsecutive() {
        assertThat(subject.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 })).isEqualTo(4);
        assertThat(subject.longestConsecutive(new int[] { 1, 2, 0, 1 })).isEqualTo(3);
        assertThat(subject.longestConsecutive(new int[0])).isEqualTo(0);
    }

}
