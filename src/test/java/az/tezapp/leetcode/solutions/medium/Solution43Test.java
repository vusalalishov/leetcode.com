package az.tezapp.leetcode.solutions.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

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
