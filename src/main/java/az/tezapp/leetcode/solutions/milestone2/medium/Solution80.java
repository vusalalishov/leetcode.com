package az.tezapp.leetcode.solutions.milestone2.medium;

public class Solution80 {

    // ACCEPTED - 71%
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int targetPointer = 0;
        int searchPointer = 1;

        int countLimit = 2;
        int currentEl = nums[targetPointer];
        int currentCount = 1;
        while (searchPointer < len) {
            int num = nums[searchPointer];
            if (num == currentEl) {
                if (currentCount < countLimit) {
                    currentCount++;
                    targetPointer++;
                    currentEl = num;
                    nums[targetPointer] = num;
                }
            } else {
                targetPointer++;
                nums[targetPointer] = num;
                currentEl = num;
                currentCount = 1;
            }

            searchPointer++;
        }

        return targetPointer + 1;
    }

}
