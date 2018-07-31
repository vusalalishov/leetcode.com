package az.tezapp.leetcode.solutions.easy;

public class Solution53 {

    // ACCEPTED - 7%
    public int maxSubArray(int[] nums) {
        return findMaxSub(0, nums.length - 1, nums);
    }

    private int findMaxSub(int from, int to, int[] nums) {
        if (from == to) {
            return nums[from];
        }
        int middle = (to + from) / 2;
        int leftSum = findMaxSub(from, middle, nums);
        int rightSum = findMaxSub(middle + 1, to, nums);
        int crossSum = findCrossSum(from, middle, to, nums);

        if (leftSum >= rightSum && leftSum >= crossSum) {
            return leftSum;
        } else if (rightSum >= leftSum && rightSum >= crossSum) {
            return rightSum;
        } else return crossSum;
    }

    private int findCrossSum(int from, int middle, int to, int[] nums) {
        int leftSum = Integer.MIN_VALUE;
        int tmpLeftSum = 0;
        for (int i = middle; i >= from; i--) {
            tmpLeftSum += nums[i];
            if (leftSum < tmpLeftSum) {
                leftSum = tmpLeftSum;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        int tmpRightSum = 0;
        for (int i = middle + 1; i <= to; i++) {
            tmpRightSum += nums[i];
            if (tmpRightSum > rightSum) {
                rightSum = tmpRightSum;
            }
        }

        return leftSum + rightSum;
    }

}
