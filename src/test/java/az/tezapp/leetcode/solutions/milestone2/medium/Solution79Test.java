package az.tezapp.leetcode.solutions.milestone2.medium;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution79Test {

    private Solution79 subject = new Solution79();

    @Test
    void testExists() {

//        assertThat(subject.exist(new char[][] {
//                { 'A', 'B', 'C', 'E' },
//                { 'S', 'F', 'C', 'S' },
//                { 'A', 'D', 'E', 'E' }
//        }, "ABCCED")).isTrue();

//        assertThat(subject.exist(new char[][] {
//                { 'A', 'A' }
//        }, "AAA")).isFalse();

        assertThat(subject.exist(new char[][] {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'E', 'S' },
                { 'A', 'D', 'E', 'E' }
        }, "ABCEFSADEESE")).isTrue();

    }

}
