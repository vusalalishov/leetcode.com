package az.tezapp.leetcode.solutions.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution43 {

    // 13% - TODO: optimize it
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

        return sb.reverse().toString();
    }

    private List<Integer> mul(String num, int multiplier, int indent) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < indent; i++) {
            res.add(0);
        }
        int len = num.length();
        int remainder = 0;
        for (int i = len - 1; i >= 0; i--) {
            int k = num.charAt(i) - 48;
            int mul = k * multiplier + remainder;
            remainder = mul / 10;
            res.add(mul % 10);
        }
        if (remainder != 0) {
            res.add(remainder);
        }
        return res;
    }

}
