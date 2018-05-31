package az.tezapp.leetcode.solutions.easy;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        int[] nums = new int[] {5, 7, 3, 5, 2, 10, -20, -3, -2, -7, 8};
        int target = 10;
        Solution1 solution1 = new Solution1();
        System.out.println(Arrays.toString(solution1.twoSum2(nums, target)));
    }

    // Beats 14% submissions
    public int[] twoSum1(int[] nums, int target) {
        int[] reversals = new int[nums.length];

        for (int i = 0; i < reversals.length; i++) {
            reversals[i] = target - nums[i];
        }

        for (int i = 0; i < reversals.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (reversals[i] == nums[j] && i != j) {
                    return new int[] {i >= j ? j : i, i >= j ? i : j};
                }
            }
        }

        return new int[] {-1, -1};

    }

    // Beats 91.85% of all submissions
    public int[] twoSum2(int[] nums, int target) {

        int [] sorted = new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, sorted.length);
        Arrays.sort(sorted);

        for (int i = 0; i < nums.length; i++) {
            int toSearch = target - nums[i];
            int indexInSorted = binarySearch(sorted, toSearch);
            if (indexInSorted != - 1) {
                int realIndex = linearSearch(nums, toSearch);
                if (realIndex != i) {
                    return new int[]{i, realIndex};
                }
            }
        }

        return new int[] {-1, -1};

    }

    private int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    private int binarySearch(int[] nums, int target) {
        return doBinarySearch(nums, 0, nums.length, target);
    }

    private int doBinarySearch(int[] nums, int start, int end, int target) {
        int middle = (end + start) / 2;
        if (nums[middle] == target) return middle;
        if (end - start == 1) return -1;
        if (target > nums[middle]) {
            return doBinarySearch(nums, middle, end, target);
        } else {
            return doBinarySearch(nums, start, middle, target);
        }
    }

}
