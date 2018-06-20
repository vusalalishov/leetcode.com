package az.tezapp.leetcode.solutions.medium;

public class Solution48 {

    // 100% - ACCEPTED
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int k = n - 1;
        int rowCount = n / 2;
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < rowCount; i++) {
            for (int j = left; j < right; j++) {

                int row = j;
                int col = right;

                int tmp = matrix[row][col];
                matrix[row][col] = matrix[i][j];

                // to down
                col = col - (row - left);
                row = k;
                int tmp1 = matrix[row][col];
                matrix[row][col] = tmp;

                // to left
                row = row - (right - col);
                col = left;
                int tmp2 = matrix[row][col];
                matrix[row][col] = tmp1;

                matrix[i][j] = tmp2;
            }
            left++;
            right--;
            k--;
        }
    }


}
