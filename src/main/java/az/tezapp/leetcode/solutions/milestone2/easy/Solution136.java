package az.tezapp.leetcode.solutions.milestone2.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution136 {

    // ACCEPTED - 30%
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.iterator().next();
    }

}
