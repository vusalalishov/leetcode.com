package az.tezapp.leetcode.solutions.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution47 {

    // 4% vety bad! TODO: optimize it
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];
        return new ArrayList<>(findPermutationFor(nums, used, 0));
    }

    private Set<List<Integer>> findPermutationFor(int[] nums, boolean[] used, int depth) {
        int len = nums.length;
        Set<List<Integer>> out = new HashSet<>();
        if (depth == len - 1) {
            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    out.add(tmp);
                    break;
                }
            }
            return out;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                Set<List<Integer>> perms = findPermutationFor(nums, used, depth + 1);
                used[i] = false;
                for (List<Integer> perm : perms) {
                    perm.add(nums[i]);
                }
                out.addAll(perms);
            }
        }

        return out;
    }

}
