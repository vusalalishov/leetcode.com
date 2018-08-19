package az.tezapp.leetcode.solutions.easy;

import az.tezapp.leetcode.solutions.milestone1.easy.Solution58;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution58Test {

    private Solution58 subject = new Solution58();

    @Test
    void testLengthOfLastWord() {
        assertThat(subject.lengthOfLastWord("Hello World")).isEqualTo(5);
        assertThat(subject.lengthOfLastWord("a ")).isEqualTo(1);
    }

}
