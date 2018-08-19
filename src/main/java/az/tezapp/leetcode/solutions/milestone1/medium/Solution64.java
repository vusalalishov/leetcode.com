package az.tezapp.leetcode.solutions.milestone1.medium;

public class Solution64 {

    public static void main(String[] args) {
        Solution64 solution = new Solution64();
        System.out.println(solution.minPathSum(new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }

    // TODO: Optimize
    // 52%
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int top = i == 0 ? Integer.MAX_VALUE : dp[i - 1][j];
                int left = j == 0 ? Integer.MAX_VALUE : dp[i][j - 1];
                dp[i][j] = Math.min(top, left) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

}
