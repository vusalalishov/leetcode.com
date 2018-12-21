package az.tezapp.leetcode.solutions.milestone2.easy;

public class Solution125 {

    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }

        int begin = 0;
        int end = len - 1;

        while (begin <= end) {
            char chBegin = convert(s.charAt(begin));
            while (begin <= end && chBegin == 0) {
                if (begin == end) {
                    break;
                }
                begin++;
                chBegin = convert(s.charAt(begin));
            }

            char chEnd = convert(s.charAt(end));
            while (begin <= end && chEnd == 0) {
                if (begin == end) {
                    break;
                }
                end--;
                chEnd = convert(s.charAt(end));
            }

            if (chBegin != chEnd) {
                return false;
            }
            begin++;
            end--;
        }

        return true;
    }

    private char convert(char input) {
        if ((input >= 'A' && input <= 'Z') || (input >= 'a' && input <= 'z') || (input >= '0' && input <= '9')) {
            if (input >= 'a') {
                return (char)(input - 32);
            }
            return input;
        }
        return 0;
    }

}
