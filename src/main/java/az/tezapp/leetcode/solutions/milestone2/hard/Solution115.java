package az.tezapp.leetcode.solutions.milestone2.hard;

public class Solution115 {

    // ACCEPTED - 37%
    public int numDistinct(String s, String t) {
        int rows = t.length();
        int cols = s.length();

        if (rows == 0 || cols == 0) {
            return 0;
        }

        int[][] dp = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < row) {
                    dp[row][col] = 0;
                } else {
                    int prevValue = col == 0 ? 0 : dp[row][col - 1];
                    if (s.charAt(col) == t.charAt(row)) {
                        int topValue = row == 0 ? 1 : dp[row - 1][col - 1];
                        dp[row][col] = topValue + prevValue;
                    } else {
                        dp[row][col] = prevValue;
                    }
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }

}
