package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution16 {

    public static void main(String[] args) {
        Solution16 solution = new Solution16();
        System.out.println(solution.threeSumClosest2(new int[] {1,1,1,0}, -100));
    }

    // After reading discussion
    public int threeSumClosest2(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    // Accepted - Bad solution!
    public int threeSumClosest(int[] nums, int target) {
        List<TwoSum> twoSums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                twoSums.add(new TwoSum(i, j, nums[i] + nums[j]));
            }
        }
        int closestSum = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < twoSums.size(); j++) {
                if (twoSums.get(j).index1 != i && twoSums.get(j).index2 != i) {
                    int tmpVal = Math.abs(target - (nums[i] + twoSums.get(j).sum));
                    if (tmpVal < closestSum) {
                        sum =  nums[i] + twoSums.get(j).sum;
                        closestSum = tmpVal;
                    }
                }
            }
        }

        return sum;
    }

    class TwoSum {
        int index1;
        int index2;
        int sum;

        public TwoSum(int index1, int index2, int sum) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "TwoSum{" +
                    "index1=" + index1 +
                    ", index2=" + index2 +
                    ", sum=" + sum +
                    '}';
        }
    }

}
