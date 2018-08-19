package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {

    private final Map<Character, String> charMap = new HashMap<>();
    {
        charMap.put('2', "abc");
        charMap.put('3', "def");
        charMap.put('4', "ghi");
        charMap.put('5', "jkl");
        charMap.put('6', "mno");
        charMap.put('7', "pqrs");
        charMap.put('8', "tuv");
        charMap.put('9', "wxyz");
    }

    // ACCEPTED - 11%
    public List<String> letterCombinations(String digits) {
        return combinations(digits, digits.length() - 1);
    }

    private List<String> combinations(String digits, int i) {
        List<String> out = new ArrayList<>();
        if (i < 0) {
            return Collections.emptyList();
        }
        char digit = digits.charAt(i);
        String letters = charMap.get(digit);
        int len = letters.length();
        for (int j = 0; j < len; j++) {
            List<String> combinations = combinations(digits, i - 1);
            if (combinations.isEmpty()) {
                out.add("" + letters.charAt(j));
            } else {
                for (int k = 0; k < combinations.size(); k++) {
                    combinations.set(k, combinations.get(k) + letters.charAt(j));
                }
            }
            out.addAll(combinations);
        }
        return out;
    }

}
