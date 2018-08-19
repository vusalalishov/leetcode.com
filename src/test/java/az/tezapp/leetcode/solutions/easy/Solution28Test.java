package az.tezapp.leetcode.solutions.easy;

import az.tezapp.leetcode.solutions.milestone1.easy.Solution28;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution28Test {

    private Solution28 subject = new Solution28();

    @Test
    void testStrStr() {
        assertThat(subject.strStr("hello", "ll")).isEqualTo(2);
        assertThat(subject.strStr("hello", "l")).isEqualTo(2);
        assertThat(subject.strStr("hello", "he")).isEqualTo(0);
        assertThat(subject.strStr("hello", "e")).isEqualTo(1);
        assertThat(subject.strStr("hello", "h")).isEqualTo(0);
        assertThat(subject.strStr("hello", "")).isEqualTo(0);
        assertThat(subject.strStr("hello", "as")).isEqualTo(-1);
    }

}
