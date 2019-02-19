package az.tezapp.leetcode.solutions.miliestone3.medium;

import az.tezapp.leetcode.solutions.milestone3.medium.Solution240;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class Solution240Test {

    private Solution240 subject = new Solution240();

    @Test
    void testSearchMatrix() {
        int[][] input = {
                {3, 3, 8, 13, 13, 18},
                {4, 5, 11, 13, 18, 20},
                {9, 9, 14, 15, 23, 23},
                {13, 18, 22, 22, 25, 27},
                {18, 22, 23, 28, 30, 33},
                {21, 25, 28, 30, 35, 35},
                {24, 25, 33, 36, 37, 40}
        };

//        assertTrue(subject.searchMatrix(input,9));

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.println("Check: " + input[i][j]);
                assertTrue(subject.searchMatrix(input,input[i][j]));
                System.out.println("Passed: " + input[i][j]);
            }
        }
    }

}
