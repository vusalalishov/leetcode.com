package az.tezapp.leetcode.solutions.milestone3.medium;

public class Solution240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        final int m = matrix.length;
        if (m == 0 || matrix[0].length == 0) {
            return false;
        }
        final int n = matrix[0].length;

        return searchMatrix(matrix, target, 0, m - 1, 0, n - 1);
    }

    public boolean searchMatrix(int[][] matrix, int target, int rowStart, int rowEnd, int colStart, int colEnd) {
        int rowMiddle = rowStart + (rowEnd - rowStart) / 2;
        int colMiddle = colStart + (colEnd - colStart) / 2;
        if (rowStart > rowEnd || colStart > colEnd) {
            return false;
        }
        int valMiddle = matrix[rowMiddle][colMiddle];
        if (target == valMiddle) {
            return true;
        }
        if (target < valMiddle) {
            return searchMatrix(matrix, target, rowStart, rowEnd, colStart, colMiddle - 1)
                    || searchMatrix(matrix, target, rowStart, rowMiddle - 1, colMiddle, colEnd);
        } else {
            return searchMatrix(matrix, target, rowStart, rowEnd, colMiddle + 1, colEnd)
                    || searchMatrix(matrix, target, rowMiddle + 1, rowEnd, colStart, colMiddle);
        }
    }

}
