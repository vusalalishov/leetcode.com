package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution18 {

    public static void main(String[] args) {
        Solution18 solution = new Solution18();
//        System.out.println(solution.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
//        System.out.println(solution.fourSum(new int[] {0, 0, 0, 0}, 0));
//        System.out.println(solution.fourSum(new int[] {-1,0,1,2,-1,-4}, -1));
        System.out.println(solution.fourSum(new int[] {-5,5,4,-3,0,0,4,-2}, 4));
    }

    // TODO: try to expand around every element - and check 4 sum like: {1,[2,(3),4,5],6} and {[1,2,(3),4],5,6} - here the middle is 3 - do it for all elements
    // Accepted, 117ms - bad performance - to be optimized
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int len = nums.length;
        if (len < 4) {
            return Collections.emptyList();
        }

        Map<Integer, List<int[]>> sumMap = new HashMap<>();
        Set<List<Integer>> output = new HashSet<>();

        for (int a = 0; a < len; a++) {
            for (int b = a + 1; b < len; b++) {
                if (a == b) {
                    continue;
                }
                int sum = nums[a] + nums[b];
                int expectedSum = target - sum;

                if (sumMap.containsKey(expectedSum)) {
                    List<int[]> sums = sumMap.get(expectedSum);
                    for (int[] items : sums) {
                        int c = items[0];
                        int d = items[1];
                        if (a == c || a == d || b == c || b == d) {
                            continue;
                        }

                        output.add(merge(new int[]{
                                nums[a] < nums[b] ? nums[a] : nums[b],
                                nums[a] > nums[b] ? nums[a] : nums[b]
                        }, new int[]{
                                nums[c],
                                nums[d]
                        }));

                    }
                }

                if (!sumMap.containsKey(sum)) {
                    sumMap.put(sum, new ArrayList<>());
                }
                sumMap.get(sum).add(new int[] {
                    nums[a] <= nums[b] ? a : b,
                    nums[a] > nums[b] ? a : b
                });
            }
        }

        return new ArrayList<>(output);
    }

    private List<Integer> merge(int[] a, int[] b) {
        Integer[] sorted = new Integer[4];
        int aIndex = 0;
        int bIndex = 0;
        int sortedIndex = 0;
        for (; sortedIndex < 3 && aIndex < a.length && bIndex < b.length; sortedIndex++) {
            if (a[aIndex] <= b[bIndex]) {
                sorted[sortedIndex] = a[aIndex];
                aIndex++;
            } else {
                if (bIndex < b.length) {
                    sorted[sortedIndex] = b[bIndex];
                    bIndex++;
                }
            }
        }

        for (int i = aIndex; i < a.length; i++) {
            sorted[sortedIndex++] = a[i];
        }

        for (int i = bIndex; i < b.length; i++) {
            sorted[sortedIndex++] = b[i];
        }

        return Arrays.asList(sorted);
    }

}
