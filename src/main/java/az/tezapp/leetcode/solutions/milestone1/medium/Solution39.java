package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution39 {

    // 27%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combSum(candidates, 0, target);
    }

    private List<List<Integer>> combSum(int[] candidates, int i, int target) {
        if (i >= candidates.length || target < candidates[i]) {
            return Collections.emptyList();
        }
        int candidate = candidates[i];
        List<List<Integer>> out = new ArrayList<>();
        int n = target / candidate;
        if (target % candidate == 0) {
            out.add(repeatTimes(candidate, n));
        }
        int tmpInc = target % candidate == 0 ? 0 : 1;
        for (int j = 0; j < n + tmpInc; j++) {
            int val = candidate * j;
            List<List<Integer>> allCombinations = combSum(candidates, i + 1, target - val);
            for (List<Integer> combination : allCombinations) {
                combination.addAll(repeatTimes(candidate, j));
            }
            out.addAll(allCombinations);
        }
        return out;
    }

    private List<Integer> repeatTimes(int k, int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            n--;
            list.add(k);
        }
        return list;
    }

}
