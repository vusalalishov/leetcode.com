package az.tezapp.leetcode.solutions.easy;

import az.tezapp.leetcode.solutions.milestone1.easy.Solution35;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution35Test {

    private Solution35 subject = new Solution35();

    @Test
    void testSearchInsert() {
        assertThat(subject.searchInsert(new int[]{-20, 1, 2, 3}, 1)).isEqualTo(1);
        assertThat(subject.searchInsert(new int[]{-9, -5, -1, 1, 2, 3}, 10)).isEqualTo(6);
        assertThat(subject.searchInsert(new int[]{-9, -5, -1, 1, 2, 3}, -20)).isEqualTo(0);
        assertThat(subject.searchInsert(new int[]{1, 3, 5, 6}, 2)).isEqualTo(1);
    }

}
