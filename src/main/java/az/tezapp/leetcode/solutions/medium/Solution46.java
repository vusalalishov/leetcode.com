package az.tezapp.leetcode.solutions.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {

    // 64%
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];
        return findPermutationFor(nums, used, 0);
    }

    private List<List<Integer>> findPermutationFor(int[] nums, boolean[] used, int depth) {
        int len = nums.length;
        List<List<Integer>> out = new ArrayList<>();
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
                List<List<Integer>> perms = findPermutationFor(nums, used, depth + 1);
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
