package az.tezapp.leetcode.solutions.medium;

public class Solution91 {

    // go from back to front
    public int numDecodings(String s) {
        final int zeroIndex = 48;
        int len = s.length();
        int[] combinationCount = new int[len];
        int prev = 0;
        for (int i = 0; i < len; i++) {
            int tmp = s.charAt(i) - zeroIndex;
            int tmpVal = prev * 10 + tmp;
            if (tmp == 0 && tmpVal == 0) {
                return 0;
            }
            if (tmp == 0) {
                if (tmpVal > 20) {
                    return 0;
                } else {
                    combinationCount[i] = i < 2 ? 1 : combinationCount[i - 2];
                }
            } else if (tmpVal > 26) {
                combinationCount[i] = i < 1 ? 0 : combinationCount[i - 1];
            } else if (tmpVal == 0 && i > 0) {
                combinationCount[i] = combinationCount[i - 1];
            } else if (prev == 0 && i > 0) {
                combinationCount[i] = combinationCount[i - 1];
            } else {
                combinationCount[i] = (i < 1 ? 0 : combinationCount[i - 1]) + 1;
            }
            prev = tmp;
        }

        int n = combinationCount[len - 1];
        int count = n;
        int nHalf = n / 2 - 1;
        while (nHalf > 0) {
            count += nHalf;
            nHalf -= 1;
        }

        return count;
    }

}
