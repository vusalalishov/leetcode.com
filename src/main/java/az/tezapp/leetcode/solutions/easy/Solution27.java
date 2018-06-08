package az.tezapp.leetcode.solutions.easy;

public class Solution27 {

    // TODO: optimize it
    // 17% - ACCEPTED
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length - 1;
        int i = 0;
        while (n >= 0 && nums[n] == val) {
            n--;
        }
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n];
                n--;
                while (nums[n] == val) {
                    n--;
                }
            }
            i++;
        }
        return n + 1;
    }

}
