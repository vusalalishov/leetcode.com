package az.tezapp.leetcode.solutions.milestone3.medium;

public class Solution238 {

    // Runtime: O(n), Space: O(n) - ACCEPTED - 36%
    public int[] productExceptSelf(int[] nums) {

        int[] leftToRight = new int[nums.length];
        int[] rightToLeft = new int[nums.length];

        // fill left to right
        for (int i = 0; i < nums.length; i++) {
            leftToRight[i] = i > 0 ? leftToRight[i - 1] * nums[i - 1] : 1;
        }

        // fill right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            rightToLeft[i] = i == nums.length - 1 ? 1 : rightToLeft[i + 1] * nums[i + 1];
        }

        // loop through all elements and multiply them
        for (int i = 0; i < nums.length; i++) {
            leftToRight[i] = leftToRight[i] * rightToLeft[i];
        }

        return leftToRight;
    }

    // Runtime: O(n), Space: O(1) - ACCEPTED - 100%
    public int[] productExceptSelfOptimized(int[] nums) {

        int[] output = new int[nums.length];

        // fill left to right
        for (int i = 0; i < nums.length; i++) {
            output[i] = i > 0 ? output[i - 1] * nums[i - 1] : 1;
        }

        int prevValue = nums[nums.length - 1];
        // fill right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i < nums.length - 1) {
                output[i] *= prevValue;
                prevValue *= nums[i];
            }
        }

        return output;
    }

}
