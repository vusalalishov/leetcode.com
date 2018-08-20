package az.tezapp.leetcode.solutions.milestone2.easy;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution67Test {

    private Solution67 subject = new Solution67();

    @Test
    void testAddBinary() {
        assertThat(subject.addBinary("11", "01")).isEqualTo("100");
        assertThat(subject.addBinary("1010", "1011")).isEqualTo("10101");
        assertThat(subject.addBinary("1010", "1")).isEqualTo("1011");
    }

}
