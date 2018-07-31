package az.tezapp.leetcode.solutions.easy;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution53Test {

    private Solution53 subject = new Solution53();

    @Test
    void testMaxSubArray() {
        assertThat(subject.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4})).isEqualTo(6);
    }

}
