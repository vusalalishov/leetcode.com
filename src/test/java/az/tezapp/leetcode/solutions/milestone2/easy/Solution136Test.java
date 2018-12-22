package az.tezapp.leetcode.solutions.milestone2.easy;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution136Test {

    private Solution136 subject = new Solution136();

    @Test
    void testSingleNumber() {
        assertThat(subject.singleNumber(new int[] {1, 2, 3, 2, 3, 4, 4, 5, 6, 5, 6})).isEqualTo(1);
    }

}
