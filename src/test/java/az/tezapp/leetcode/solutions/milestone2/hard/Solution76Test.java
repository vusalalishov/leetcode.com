package az.tezapp.leetcode.solutions.milestone2.hard;

import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Solution76Test {

    private Solution76 subject = new Solution76();

    @ParameterizedTest
    @CsvSource({
            "ADOBECODEBANC, ABC, BANC",
            "ADOBECODEBANC, ABCD, ADOBEC",
            "'','',''",
            "ADOBECODEBANC, A, A",
            "AA, AA, AA",
    })
    void testMinWindow(String s, String t, String e) {
        assertThat(subject.minWindow(s, t)).isEqualTo(e);
    }

}
