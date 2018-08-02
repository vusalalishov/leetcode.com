package az.tezapp.leetcode.solutions.easy;

public class Solution58 {

    // ACCEPTED - 98%
    public int lengthOfLastWord(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int wordLen = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                wordLen++;
            } else if (wordLen != 0) {
                break;
            }
        }
        return wordLen;
    }

}
