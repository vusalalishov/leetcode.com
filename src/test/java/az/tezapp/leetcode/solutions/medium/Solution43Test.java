package az.tezapp.leetcode.solutions.medium;

import az.tezapp.leetcode.solutions.milestone1.medium.Solution43;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution43Test {

    private Solution43 subject = new Solution43();

    @Test
    void testMultiply() {
        assertThat(subject.multiply("123", "456")).isEqualTo("56088");
        assertThat(subject.multiply("123", "1")).isEqualTo("123");
        assertThat(subject.multiply("1", "123")).isEqualTo("123");
        assertThat(subject.multiply("123", "0")).isEqualTo("0");
    }

}
