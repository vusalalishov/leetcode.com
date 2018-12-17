package az.tezapp.leetcode.solutions.milestone2.hard;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution115Test {

    private Solution115 subject = new Solution115();

    @Test
    void testNumDistinct1() {
        assertThat(subject.numDistinct("aabb", "abb")).isEqualTo(2);
        assertThat(subject.numDistinct("b", "b")).isEqualTo(1);
        assertThat(subject.numDistinct("rabbbit", "rabbit")).isEqualTo(3);
        assertThat(subject.numDistinct("rabbbbt", "rabit")).isEqualTo(0);
        assertThat(subject.numDistinct("rabbbit", "rabit")).isEqualTo(3);
        assertThat(subject.numDistinct("rabbbiit", "rabit")).isEqualTo(6);
        assertThat(subject.numDistinct("babgbag", "bag")).isEqualTo(5);
    }

}
