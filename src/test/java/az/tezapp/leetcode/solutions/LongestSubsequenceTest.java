package az.tezapp.leetcode.solutions;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class LongestSubsequenceTest {

    private LongestSubsequence subject = new LongestSubsequence();

    @Test
    void testLongestSubsequence() {
        assertThat(subject.longestSubsequence("ABCEBGHA", "KUBANBIBAT")).isEqualTo("ABBA");
        assertThat(subject.longestSubsequence("aaaa", "aa")).isEqualTo("aa");
        assertThat(subject.longestSubsequence("ABC", "ABC")).isEqualTo("ABC");
    }

}
