package az.tezapp.leetcode.solutions.milestone2.medium;

public class Solution81 {

    // ACCEPTED - 100% - Good job!
    public boolean search(int[] nums, int target) {
        int from = 0;
        int to = nums.length;
        while (from < to) {
            int middle = (from + to) / 2;
            int valMiddle = nums[middle];
            int valFrom = nums[from];
            int valTo = nums[to - 1];
            if (target == valMiddle) {
                return true;
            }
            if (valFrom == valTo) {
                int oldFrom = from;
                while (from < to && nums[from] == nums[to - 1]) {
                    from++;
                }
                if (from != oldFrom) {
                    continue;
                }
            }
            if (target > valMiddle) {
                if (valTo >= valMiddle) {
                    if (target <= valTo) {
                        from = middle + 1;
                    } else {
                        to = middle;
                    }
                } else {
                    from = middle + 1;
                }
            } else {
                if (valFrom <= valMiddle) {
                    if (target >= valFrom) {
                        to = middle;
                    } else {
                        from = middle + 1;
                    }
                } else {
                    to = middle;
                }
            }
        }
        return false;
    }

}
