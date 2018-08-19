package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.Arrays;

public class Solution31 {

    // ACCEPTED - 63%
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }

        int i = len - 2;
        for (; i >= 0; i--) {
            int n = nums[i];
            int minIndex = i + 1;
            int minDistance = nums[minIndex] - n;
            for (int j = i + 2; j < len; j++) {
                if (nums[j] - n > 0 && (minDistance < 0 || nums[j] - n < minDistance)) {
                    minIndex = j;
                    minDistance = nums[j] - n;
                }
            }
            if (nums[minIndex] > n) {
                int tmp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = tmp;
                break;
            }
        }

        if (i == -1) {
            Arrays.sort(nums);
            return;
        }

        boolean sorted = true;
        while (sorted) {
            sorted = false;
            for (int k = i + 1; k < len - 1; k++) {
                if (nums[k] > nums[k + 1]) {
                    int tmp = nums[k];
                    nums[k] = nums[k + 1];
                    nums[k + 1] = tmp;
                    sorted = true;
                }
            }
        }

    }


}
