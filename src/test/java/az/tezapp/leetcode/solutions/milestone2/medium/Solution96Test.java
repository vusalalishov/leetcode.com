package az.tezapp.leetcode.solutions.milestone2.medium;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution96Test {

    private Solution96 subject = new Solution96();

    @Test
    void testNumTrees() {
//        assertThat(subject.numTrees(4)).isEqualTo(14);
//        assertThat(subject.numTrees(5)).isEqualTo(42);
        assertThat(subject.numTrees(6)).isEqualTo(132);
    }

}
