package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return new ArrayList<>(combCount(candidates, 0, target));
    }

    // ACCEPTED: too long TODO: [to be optimized]
    private Set<List<Integer>> combCount(int[] candidates, int i, int target) {
        int len = candidates.length;
        if (i >= len || (i == len - 1 && candidates[i] != target)) {
            return Collections.emptySet();
        }

        Set<List<Integer>> comb = new HashSet<>();
        if (candidates[i] == target) {
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            comb.add(list);
        }

        List<Integer> out = new ArrayList<>();
        if (i != len - 1) {
            out.add(0);
        }
        if (candidates[i] < target) {
            out.add(candidates[i]);
        }
        for (Integer val: out) {
            Set<List<Integer>> lists = combCount(candidates, i + 1, target - val);
            if (val != 0) {
                for (List<Integer> list : lists) {
                    list.add(val);
                }
            }
            comb.addAll(lists);
        }
        return comb;
    }

}
