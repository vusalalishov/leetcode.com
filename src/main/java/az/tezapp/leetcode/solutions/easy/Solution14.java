package az.tezapp.leetcode.solutions.easy;

public class Solution14 {

    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        String s = solution.longestCommonPrefix(new String[]{
                "aa",
                "a"
        });
        System.out.println(s);
    }

    // 57%
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }

        String firstEl = strs[0];

        if (len == 1) {
            return firstEl;
        }

        int prefixLength = firstEl.length();
        for (int i = 1; i < len && prefixLength != 0; i++) {
            int j = 0;
            while (j < prefixLength && strs[i].length() > j && strs[i].charAt(j) == firstEl.charAt(j)) {
                j++;
            }
            prefixLength = j;
        }

        return firstEl.substring(0, prefixLength);

    }

}
