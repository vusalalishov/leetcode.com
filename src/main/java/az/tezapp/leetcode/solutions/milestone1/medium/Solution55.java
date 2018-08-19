package az.tezapp.leetcode.solutions.milestone1.medium;

public class Solution55 {

    // ACCEPTED - 79%
    public boolean canJump(int[] nums) {

        int len = nums.length;
        if (len <= 1) {
            return true;
        }

        int pos = len - 2;
        boolean broken = false;
        while (pos >= 0 && !broken) {
            if (nums[pos] == 0) {
                if (pos - 1 < 0) {
                    broken = true;
                    break;
                }

                boolean jumped = false;
                int jumpsRequired = 2;

                for (int i = pos - 1; i >= 0; i--) {
                    if (nums[i] >= jumpsRequired) {
                        jumped = true;
                        pos = i;
                        break;
                    }
                    jumpsRequired++;
                }
                broken = !jumped;
            } else {
                pos--;
            }
        }

        return !broken;
    }

}
