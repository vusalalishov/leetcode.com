package az.tezapp.leetcode.solutions.milestone2.medium;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution74Test {

    private Solution74 subject = new Solution74();

    @Test
    void testSearchMatrix() {
        assertThat(subject.searchMatrix(new int[][] {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 3 )).isTrue();

        assertThat(subject.searchMatrix(new int[][] {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 44 )).isFalse();

        assertThat(subject.searchMatrix(new int[][] {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 50 )).isTrue();

        assertThat(subject.searchMatrix(new int[][] {
                {1}
        }, 2 )).isFalse();

        assertThat(subject.searchMatrix(new int[][] {
                {1}
        }, 0 )).isFalse();
    }

}
