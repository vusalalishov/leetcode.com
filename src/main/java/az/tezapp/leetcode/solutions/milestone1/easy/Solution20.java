package az.tezapp.leetcode.solutions.milestone1.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution20 {

    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        System.out.println(solution.isValid("[][[]]"));
    }

    // 93%
    public boolean isValid(String s) {
        int len = s.length();

        if (len == 0 || len % 2 != 0) {
            return false;
        }

        Map<Character, Character> braceMap = new HashMap<>();
        braceMap.put(')', '(');
        braceMap.put('}', '{');
        braceMap.put(']', '[');

        char[] stack = new char[len];
        int top = 0;
        for (int i = 0; i < len; i++) {
            char tmp = s.charAt(i);
            if (top > 0 && braceMap.keySet().contains(tmp)) {
                if (stack[top - 1] == braceMap.get(tmp)) {
                    top--;
                } else {
                    return false;
                }
            } else {
                stack[top++] = tmp;
            }
        }

        return top == 0;
    }


}
