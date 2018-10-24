package az.tezapp.leetcode.solutions.milestone2.hard;

import java.util.Arrays;

public class Solution87 {

    // ACCEPTED - 21%
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int len = s1.length();
        if (len == 1) {
            return s1.equals(s2);
        }

        byte[] s1Bytes = s1.getBytes();
        Arrays.sort(s1Bytes);

        byte[] s2Bytes = s2.getBytes();
        Arrays.sort(s2Bytes);

        if (!new String(s1Bytes).equals(new String(s2Bytes))) {
            return false;
        }

        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len -  i))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution87 solution = new Solution87();
        System.out.println(solution.isScramble("abc", "cab"));
    }

}
