package az.tezapp.leetcode.solutions.inprogress.hard;

import java.util.ArrayList;
import java.util.List;

public class Solution30 {

    public List<Integer> findSubstring(String s, String[] words) {

//        if (s.isEmpty() || words.length == 0) {
//            return Collections.emptyList();
//        }
//
//        int len = s.length();
//        int wordLen = words[0].length();
//        int[] possibleIndexes = new boolean[len];
//        for (String word : words) {
//            int lastIndex = 0;
//            int index = s.indexOf(word);
//            while (index >= 0) {
//                possibleIndexes[index + lastIndex] = true;
//                lastIndex += index + wordLen;
//                index = s.indexOf(word, lastIndex);
//            }
//        }


        return null;
    }

    private List<String> buildCombinations(String[] words) {
        int n = words.length + 1;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        boolean used[] = new boolean[n];
        List<String> res = new ArrayList<>();
        List<List<Integer>> perms = findPerms(nums, used, 0);
        for (List<Integer> perm : perms) {
            StringBuilder sb = new StringBuilder();
            for (Integer index : perm) {
                sb.append(words[index]);
            }
            res.add(sb.toString());
        }
        return res;
    }

    private List<List<Integer>> findPerms(int[] nums, boolean[] used, int depth) {
        int len = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        if (depth == len - 1) {
            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    res.add(tmp);
                    return res;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                List<List<Integer>> perms = findPerms(nums, used, depth + 1);
                used[i] = false;
                for (List<Integer> perm : perms) {
                    perm.add(nums[i]);
                }
                res.addAll(perms);
            }
        }

        return res;
    }

    private boolean isUniform(String s) {
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }


}
