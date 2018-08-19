package az.tezapp.leetcode.solutions.milestone1.easy;

public class Solution28 {

    // ACCEPTED - 63%
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if (nLen == 0) {
            return 0;
        }
        if (hLen == 0 || nLen > hLen) {
            return -1;
        }

        int nSum = needle.charAt(0);
        for (int i = 1; i < nLen; i++) {
            nSum += needle.charAt(i);
        }

        int hSum = 0;
        int start = 0;
        int end = nLen - 1;
        for (int i = 0; i < end; i++) {
            hSum += haystack.charAt(i);
        }

        while (end < hLen) {
            hSum += haystack.charAt(end);
            if (hSum == nSum) {
                boolean equal = true;
                for (int i = start, j = 0; i <= end; i++, j++) {
                    if (haystack.charAt(i) != needle.charAt(j)) {
                        equal = false;
                    }
                }
                if (equal) {
                    return start;
                }
            }
            hSum -= haystack.charAt(start++);
            end++;
        }

        return -1;
    }

}
