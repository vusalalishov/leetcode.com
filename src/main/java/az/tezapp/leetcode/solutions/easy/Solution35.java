package az.tezapp.leetcode.solutions.easy;

public class Solution35 {

    // 100% - ACCEPTED
    public int searchInsert(int[] nums, int target) {
        return searchInsertPosition(0, nums.length - 1, target, nums);
    }

    private int searchInsertPosition(int from, int to, int target, int[] nums) {
        int middle = (to + from) / 2;
        if (nums[middle] == target) {
            if (nums[middle] == target) {
                return middle;
            }
        }

        if (from == to) {
            return nums[middle] > target ? middle : middle + 1;
        }

        if (target < nums[middle]) {
            return searchInsertPosition(from, middle, target, nums);
        } else {
            return searchInsertPosition(middle + 1, to, target, nums);
        }
    }

}
