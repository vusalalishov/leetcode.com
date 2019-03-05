package az.tezapp.leetcode.solutions.milestone3.medium;

public class Solution152 {

    // ACCEPTED - 99%
    public int maxProduct(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int product = 0;
        int negative = 1;
        int lastNegative = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == 0) {
                if (product < 0) {
                    if (lastNegative < i - 1 && negative != 0) {
                        product /= negative;
                    }
                }
                maxProduct = Math.max(maxProduct, Math.max(0, product));
                product = 0;
                negative = 1;
                lastNegative = 0;
            } else {
                product = product != 0 ? product * num : num;
                if (i == nums.length - 1 || (i < nums.length - 1 && nums[i + 1] == 0)) {
                    if (product < 0) {
                        if (lastNegative < i && negative != 0) {
                            product /= negative;
                        }
                    }
                }
                maxProduct = Math.max(maxProduct, product);
                if (negative >= 0) {
                    negative *= num;
                    lastNegative = i;
                }
            }
        }

        return maxProduct;
    }

}
