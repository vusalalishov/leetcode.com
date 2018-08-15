package az.tezapp.leetcode.solutions.medium;

import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution60Test {

    private Solution60 subject = new Solution60();

    @Test
    void testGetPermutation() {
        assertThat(subject.getPermutation(3, 6)).isEqualTo("321");
        assertThat(subject.getPermutation(1, 1)).isEqualTo("1");
        assertThat(subject.getPermutation(3, 3)).isEqualTo("213");
        assertThat(subject.getPermutation(4, 9)).isEqualTo("2314");
    }

}
