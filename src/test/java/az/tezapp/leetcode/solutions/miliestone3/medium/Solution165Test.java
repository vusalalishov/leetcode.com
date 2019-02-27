package az.tezapp.leetcode.solutions.miliestone3.medium;

import az.tezapp.leetcode.solutions.milestone3.medium.Solution165;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution165Test {

    private Solution165 subject = new Solution165();

    @Test
    void testCompareVersion() {
        assertThat(subject.compareVersion("1.0", "1.1")).isEqualTo(-1);
        assertThat(subject.compareVersion("1.1", "1.0")).isEqualTo(1);
        assertThat(subject.compareVersion("1.1.0.0.0.0.0.1", "1.1.0.0.0.0.0.2")).isEqualTo(-1);
    }

}
