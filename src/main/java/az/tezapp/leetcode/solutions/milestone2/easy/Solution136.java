package az.tezapp.leetcode.solutions.milestone2.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution136 {

    // ACCEPTED - 30%
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.iterator().next();
    }

    // after checking the discussion
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

}
