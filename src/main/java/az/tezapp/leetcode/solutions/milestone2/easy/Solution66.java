package az.tezapp.leetcode.solutions.milestone2.easy;

public class Solution66 {

    // ACCEPTED - 100%
    public int[] plusOne(int[] digits) {

        int len = digits.length;

        if (digits[len - 1] < 9) {
            digits[len - 1]++;
            return digits;
        } else {
            int remainder = 1;
            int tmp[] = new int[len + 1];
            for (int i = len - 1; i >= 0; i--) {
                if (remainder != 0) {
                    int tmpVal = digits[i] + remainder;
                    tmp[i + 1] = tmpVal % 10;
                    remainder = tmpVal / 10;
                } else {
                    tmp[i + 1] = digits[i];
                }
            }

            if (remainder > 0) {
                tmp[0] = remainder;
                return tmp;
            } else {
                int[] out = new int[len];
                System.arraycopy(tmp, 1, out, 0, len);
                return out;
            }
        }
    }

}
