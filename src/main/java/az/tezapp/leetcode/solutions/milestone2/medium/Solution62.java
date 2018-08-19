package az.tezapp.leetcode.solutions.milestone2.medium;

public class Solution62 {

    public static void main(String[] args) {
        Solution62 solution = new Solution62();
        System.out.println(solution.uniquePaths(1, 1));
    }

    // 87%
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        int tmpMax = Math.max(m, n);
        for (int i = 1; i < tmpMax; i++) {
            if (i < m) {
                dp[i][0] = 1;
            }
            if (i < n) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}
