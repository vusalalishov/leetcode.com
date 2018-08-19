package az.tezapp.leetcode.solutions.medium;

import java.util.Arrays;

import az.tezapp.leetcode.solutions.milestone1.medium.Solution48;
import org.junit.jupiter.api.Test;

class Solution48Test {

    private Solution48 subject = new Solution48();

    @Test
    void testRotate() {
        int[][] matrix = new int[][] {
                { 15, 13, 2, 5 },
                { 14,  3, 4, 1 },
                { 12,  6, 8, 9 },
                { 16,  7,10, 11}
        };
        subject.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
