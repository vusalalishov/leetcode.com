package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution15 {

    public static void main(String[] args) {
        Solution15 solution = new Solution15();
//        System.out.println(solution.threeSum(new int[] {}));
//        System.out.println(solution.threeSum(new int[] {-1, 10, 5, -5, 0, 35, -30, -5, 20}));
//        System.out.println(solution.threeSum(new int[] {-4, -2, -1}));
//        System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
//        System.out.println(solution.threeSum(new int[] {0, 0, 0}));
//        System.out.println(solution.threeSum(new int[] {1, 2, -2, -1}));
//        System.out.println(solution.threeSum(new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
        System.out.println(solution.threeSum(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
//        System.out.println(solution.threeSum(new int[] {-1,0,1,2,-1,-4}));
//        System.out.println(solution.threeSum(new int[] {3,0,-2,-1,1,2}));
//        System.out.println(solution.threeSum(new int[] {1,1,-2}));
    }

    // 8% - BAD!!!
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return Collections.emptyList();
        }

        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }

        List<List<Integer>> out = new ArrayList<>();

        if (zeroCount >= 3) {
            out.add(Arrays.asList(0, 0, 0));
        }

        Arrays.sort(nums);

        if (nums[0] >= 0) {
            return out;
        }


        Set<Integer> sumWithZero = new HashSet<>();
        int zIndex = 0;
        while (zeroCount > 0 && zIndex < nums.length) {
            int n = nums[zIndex];
            if (n == 0) {
                zIndex++;
                continue;
            }
            int nAbs = Math.abs(n);
            int nReverse = n * -1;
            if (!sumWithZero.contains(nAbs) && Arrays.binarySearch(nums, nReverse) >= 0) {
                sumWithZero.add(nAbs);
                out.add(Arrays.asList(n, 0, nReverse));
            }
            zIndex++;
        }

        out.addAll(findPositive(nums));
        out.addAll(findNegative(nums));

        return out;
    }

    private List<List<Integer>> findNegative(int nums[]) {
        List<List<Integer>> out = new ArrayList<>();
        Set<Integer> uniqueSum = new HashSet<>();
        int index = 0;
        while (index < nums.length && nums[index] < 0) {
            int target = nums[index];
            int targetAbs = Math.abs(target);
            if (!uniqueSum.contains(target)) {
                int posIndex = nums.length - 1;
                while (nums[posIndex] > 0 && nums[posIndex] > targetAbs - 1) {
                    posIndex--;
                }
                Set<Integer> storage = new HashSet<>();
                while ((targetAbs % 2 == 0 && nums[posIndex] >= targetAbs / 2) || (targetAbs % 2 != 0 && nums[posIndex] > targetAbs / 2)) {
                    if (!storage.contains(targetAbs - nums[posIndex])) {
                        if (nums[posIndex] == 0 || targetAbs - nums[posIndex] == 0) {
                            posIndex--;
                            continue;
                        }
                        int sIndex = Arrays.binarySearch(nums, targetAbs - nums[posIndex]);
                        if (sIndex >= 0 && sIndex != posIndex) {
                            uniqueSum.add(target);
                            storage.add(targetAbs - nums[posIndex]);
                            out.add(Arrays.asList(target, nums[posIndex], targetAbs - nums[posIndex]));
                        }
                    }
                    posIndex--;
                }
            }
            index++;
        }
        return out;
    }

    private List<List<Integer>> findPositive(int nums[]) {
        List<List<Integer>> out = new ArrayList<>();
        Set<Integer> uniqueSum = new HashSet<>();
        int index = nums.length - 1;
        while (index >= 0 && nums[index] > 0) {
            int target = nums[index];
            if (!uniqueSum.contains(target)) {
                int negIndex = 0;
                while (nums[negIndex] < 0 && Math.abs(nums[negIndex]) > target - 1) {
                    negIndex++;
                }
                Set<Integer> storage = new HashSet<>();
                while (nums[negIndex] < 0 && ((target % 2 == 0 && Math.abs(nums[negIndex]) >= target / 2) || (target % 2 != 0 && Math.abs(nums[negIndex]) > target / 2))) {
                    if (nums[negIndex] == 0 || target - Math.abs(nums[negIndex]) == 0) {
                        negIndex++;
                        continue;
                    }
                    if (!storage.contains(target - Math.abs(nums[negIndex]))) {
                        int sIndex = Arrays.binarySearch(nums, -(target - Math.abs(nums[negIndex])));
                        if (sIndex >= 0 && sIndex != negIndex) {
                            uniqueSum.add(target);
                            storage.add(target - Math.abs(nums[negIndex]));
                            out.add(Arrays.asList(target, nums[negIndex], -1 * (target + nums[negIndex])));
                        }
                    }
                    negIndex++;
                }
            }
            index--;
        }
        return out;
    }

}
