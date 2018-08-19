package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution54Test {

    private Solution54 subject = new Solution54();

    @Test
    void testSpiralOrder() {
        List<Integer> output = subject.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        assertThat(output).isEqualTo(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
    }

}
