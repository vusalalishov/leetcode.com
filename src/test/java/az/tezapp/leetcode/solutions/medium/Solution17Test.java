package az.tezapp.leetcode.solutions.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution17Test {

    @Test
    void testLetterCombinations() {
        Solution17 solution = new Solution17();
        assertThat(solution.letterCombinations("23").size()).isEqualTo(9);
    }

}
