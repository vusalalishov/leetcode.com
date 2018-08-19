package az.tezapp.leetcode.solutions.milestone1.medium;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution17Test {

    @Test
    void testLetterCombinations() {
        Solution17 solution = new Solution17();
        assertThat(solution.letterCombinations("23").size()).isEqualTo(9);
    }

}
