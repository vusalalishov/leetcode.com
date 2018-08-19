package az.tezapp.leetcode.solutions.medium;

import az.tezapp.leetcode.solutions.milestone1.medium.Solution36;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution36Test {

    private Solution36 subject = new Solution36();

    @Test
    void testIsValidSudoku() {
        char[][] source = new char[][] {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        assertThat(subject.isValidSudoku(source)).isTrue();
    }

}
