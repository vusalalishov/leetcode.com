package az.tezapp.leetcode.solutions.milestone1.medium;

public class Solution63 {

    public static void main(String[] args) {
        Solution63 solution = new Solution63();
        System.out.println(solution.uniquePathsWithObstacles(new int[][] {
                {
                    0, 0, 0
                },
                {
                    0, 1, 0
                },
                {
                    0, 0, 0
                }
        }));
    }

    // 100%
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    int top = i == 0 ? 0 : dp[i - 1][j];
                    int bottom = j == 0 ? 0 : dp[i][j - 1];
                    dp[i][j] = top + bottom;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

}
