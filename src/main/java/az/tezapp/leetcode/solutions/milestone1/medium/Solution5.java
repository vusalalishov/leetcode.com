package az.tezapp.leetcode.solutions.milestone1.medium;

public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
//        System.out.println(solution.longestPalindrome(""));
//        System.out.println(solution.longestPalindrome("a"));
//        System.out.println(solution.longestPalindrome("abad"));
//        System.out.println(solution.longestPalindrome("abacdefghjhgfasd"));
//        System.out.println(solution.longestPalindrome("jasg dagduwbabbab19238912783"));
//        System.out.println(solution.longestPalindrome("cbbd"));
//        System.out.println(solution.longestPalindrome("abcdasdfghjkldcba"));
//        System.out.println(solution.longestPalindrome("aaabaaaa"));
//        System.out.println(solution.longestPalindrome("abcba"));
//        System.out.println(solution.longestPalindrome("abcda"));
        System.out.println(solution.longestPalindrome("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
    }

    // Beats 6%
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1 || isPalindrome(s)) {
            return s;
        }

        int maxLength = 0;
        int maxIndex = 0;
        for (int step = 1; step < 3; step++) {
            for (int i = 0; i < len - step; i++) {
                if (s.charAt(i) == s.charAt(i + step)) {
                    // start checking if palindrome
                    int tmpI = i;
                    int tmpJ = i + step;
                    while (tmpI > 0 && tmpJ < len - 1) {
                        tmpI--;
                        tmpJ++;
                        if (!isPalindrome(s.substring(tmpI, tmpJ + 1))) {
                            tmpI++;
                            tmpJ--;
                            break;
                        }
                    }
                    if (tmpJ - tmpI + 1 > maxLength) {
                        maxIndex = tmpI;
                        maxLength = tmpJ - tmpI + 1;
                    }
                }
            }
        }

        return maxLength == 0 ? s.substring(0, 1) : s.substring(maxIndex, maxIndex + maxLength);

    }

    private boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

}
