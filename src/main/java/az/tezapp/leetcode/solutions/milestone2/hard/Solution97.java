package az.tezapp.leetcode.solutions.milestone2.hard;

public class Solution97 {

    // ACCEPTED - 7% [TODO: consider removing recursive call]
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }

        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }

        return isInterleaveString(s1, 0, s2, 0, s3, 0);
    }

    private boolean isInterleaveString(String s1, int s1Index, String s2, int s2Index, String s3, int s3Index) {

        if (s3Index == s3.length()) {
            return true;
        }

        char s1Char = s1Index < s1.length() ? s1.charAt(s1Index) : 0;
        char s2Char = s2Index < s2.length() ? s2.charAt(s2Index) : 0;
        char s3Char = s3.charAt(s3Index);

        return (s1Char == s3Char && isInterleaveString(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1)) ||
                (s2Char == s3Char && isInterleaveString(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1));

    }

    public static void main(String[] args) {
        Solution97 solution = new Solution97();
        System.out.println(solution.isInterleave(
                "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"
        ));
        System.out.println(solution.isInterleave(
                "aacaac",
                "aacaaeaac",
                "aacaacaaeaacaac"
        ));
    }

//    "aacaac"
//"aacaaeaac"
//"aacaacaaeaacaac"

}
