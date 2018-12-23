package az.tezapp.leetcode.solutions;

public class LongestSubsequence {

    /**
     * Given strings s1 and s2 = find the longest common subsequents in them
     * Example:
     * s1: ABCEBGHA s2: KUBANIBAT - output: ABBA
     */
    public String longestSubsequence(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        String[][] dp = new String[s1Len][s2Len];

        // fill the DP array with an empty string
        for (int s1Index = 0; s1Index < s1Len; s1Index++) {
            for (int s2Index = 0; s2Index < s2Len; s2Index++) {
                dp[s1Index][s2Index] = "";
            }
        }

        char s1First = s1.charAt(0);
        for (int col = 0; col < s2Len; col++) {
            String left = col > 0 ? dp[0][col - 1] : "";
            if (s1First == s2.charAt(col)) {
                dp[0][col] = "" + s1First;
            } else {
                dp[0][col] = left;
            }
        }

        char s2First = s2.charAt(0);
        for (int row = 0; row < s1Len; row++) {
            String top = row > 0 ? dp[row - 1][0] : "";
            if (s2First == s1.charAt(row)) {
                dp[row][0] = "" + s2First;
            } else {
                dp[row][0] = top;
            }
        }

        String longest = "";
        for (int row = 1; row < s1Len; row++) {
            for (int col = 1; col < s2Len; col++) {
                String top = dp[row - 1][col];
                String topLeft = dp[row - 1][col - 1];
                String left = dp[row][col - 1];
                char ch1 = s1.charAt(row);
                char ch2 = s2.charAt(col);
                if (ch1 == ch2) {
                    String val = topLeft + ch1;
                    if (val.isEmpty()) {
                        val += ch1;
                    }
                    dp[row][col] = val;
                    if (longest.length() < dp[row][col].length()) {
                        longest = dp[row][col];
                    }
                } else {
                    dp[row][col] = left.length() >= top.length() ? left: top;
                }
            }
        }

        return longest;
    }

}
