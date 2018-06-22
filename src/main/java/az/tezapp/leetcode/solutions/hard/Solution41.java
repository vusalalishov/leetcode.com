package az.tezapp.leetcode.solutions.hard;

public class Solution41 {

    // 80% - ACCEPTED
    public int firstMissingPositive(int[] nums) {

        int len = nums.length;

        if (len == 0) {
            return 1;
        }

        // find min max value
        int minValue = nums[0];
        int maxValue = nums[0];

        for (int i = 1; i < len; i++) {
            int tmp = nums[i];
            if (tmp < minValue) {
                minValue = tmp;
            }
            if (tmp > maxValue) {
                maxValue = tmp;
            }
        }

        if (minValue > 1) {
            return 1;
        }

        int[] positives = new int[maxValue + 1];
        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) {
                positives[nums[i]] = 1;
            }
        }

        for (int i = 1; i < maxValue; i++) {
            if (positives[i] == 0) {
                return i;
            }
        }

        return maxValue + 1;
    }

}
