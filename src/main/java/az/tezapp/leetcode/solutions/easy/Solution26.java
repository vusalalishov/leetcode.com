package az.tezapp.leetcode.solutions.easy;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 */
public class Solution26 {

    public static void main(String[] args) {
        int[] data = new int[] {
                1,1,1,2,2,2,3,4,4,4,5,6,6,6,7,8,8,8,9,9,9,9,10
        };
        Solution26 solution = new Solution26();
        int len = solution.removeDuplicates(data);
        for (int i = 0; i < len; i++) {
            System.out.print(String.format("%2d", data[i]));
        }
        System.out.println();
    }

    // ACCEPTED - 96%
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int i = 0;
        int tmp = nums[0];
        for (int j = 1; j < len; j++) {
            if (nums[j] != tmp) {
                i++;
                nums[i] = nums[j];
                tmp = nums[j];
            }
        }
        return i + 1;
    }

}
