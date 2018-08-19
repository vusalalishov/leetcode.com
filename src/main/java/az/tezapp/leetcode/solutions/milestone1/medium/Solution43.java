package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution43 {

    private final Map<Integer, List<Integer>> CACHE = new HashMap<>();

    // 13% - TODO: optimize it[Play with value caching]
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        String multiplied = len1 > len2 ? num1 : num2;
        String multiplier = num1.equals(multiplied) ? num2 : num1;

        List<List<Integer>> res = new ArrayList<>();
        int multiplierLength = multiplier.length();
        for (int i = multiplierLength - 1, j = 0; i >= 0; i--, j++) {
            res.add(mul(multiplied, multiplier.charAt(i) - 48, j));
        }

        StringBuilder sb = new StringBuilder();
        int len = res.get(res.size() - 1).size();
        int remainder = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (List<Integer> mulRes : res) {
                if (i < mulRes.size()) {
                    sum += mulRes.get(i);
                }
            }
            int rSum = sum + remainder;
            remainder = rSum / 10;
            sb.append(rSum % 10);
        }
        if (remainder != 0) {
            sb.append(remainder);
        }

        CACHE.clear();

        return sb.reverse().toString();
    }

    private List<Integer> mul(String num, int multiplier, int indent) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < indent; i++) {
            res.add(0);
        }

        if (CACHE.containsKey(multiplier)) {
            res.addAll(CACHE.get(multiplier));
            return res;
        }

        List<Integer> toCache = new ArrayList<>();

        int len = num.length();
        int remainder = 0;
        for (int i = len - 1; i >= 0; i--) {
            int k = num.charAt(i) - 48;
            int mul = k * multiplier + remainder;
            remainder = mul / 10;
            res.add(mul % 10);
            toCache.add(mul % 10);
        }
        if (remainder != 0) {
            res.add(remainder);
            toCache.add(remainder);
        }

        CACHE.put(multiplier, toCache);

        return res;
    }

}
