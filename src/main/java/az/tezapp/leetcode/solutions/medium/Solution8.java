package az.tezapp.leetcode.solutions.medium;

import org.omg.CORBA.INTERNAL;

public class Solution8 {

    public static void main(String[] args) {
        Solution8 solution = new Solution8();
        System.out.println(solution.myAtoi("-91283472332"));
    }

    // beats 53%
    public int myAtoi(String str) {
        final int zeroCode = 48;
        int len = str.length();

        if (len == 0) {
            return 0;
        }

        int i = 0;
        while (str.charAt(i) == ' ') {
            i++;
        }

        char firstChar = str.charAt(i);
        if ((firstChar < 48 || firstChar > 57) && firstChar != '-' && firstChar != '+') {
            return 0;
        }

        boolean signed = firstChar == '-';
        int out = 0;
        if (firstChar == '-' || firstChar == '+') {
            i++;
        }

        while (i < len) {
            int num = str.charAt(i) - zeroCode;
            if (num < 0 || num > 9) {
                return out;
            }
            int tmpOut = out * 10 + (signed ? -num : num);
            if (tmpOut / 10 == out) {
                out = tmpOut;
            } else {
                return signed ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
        }

        return out;
    }

}
