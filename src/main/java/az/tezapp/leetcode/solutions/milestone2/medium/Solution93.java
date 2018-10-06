package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution93 {

    // ACCEPTED - 40%
    public List<String> restoreIpAddresses(String s) {

        int len = s.length();
        if (len > 15 || len < 4) {
            return Collections.emptyList();
        }

        List<String> output = new ArrayList<>();
        LinkedList<StringBuilder> nodeStack = new LinkedList<>();
        LinkedList<Integer> nodeLevelStack = new LinkedList<>();
        checkCandidate(new StringBuilder(), s, output, nodeStack, nodeLevelStack, len, 0, 12, 0, 1);
        checkCandidate(new StringBuilder(), s, output, nodeStack, nodeLevelStack, len, 0, 12, 0, 2);
        checkCandidate(new StringBuilder(), s, output, nodeStack, nodeLevelStack, len, 0, 12, 0, 3);

        while (!nodeStack.isEmpty()) {

            StringBuilder candidate = nodeStack.pop();
            int level = nodeLevelStack.pop();
            int actualLength = candidate.length() - level;

            int maxRequiredLength = (4 - level) * 3;

            checkCandidate(candidate, s, output, nodeStack, nodeLevelStack, len, actualLength, maxRequiredLength, level, 1);
            checkCandidate(candidate, s, output, nodeStack, nodeLevelStack, len, actualLength, maxRequiredLength, level, 2);
            checkCandidate(candidate, s, output, nodeStack, nodeLevelStack, len, actualLength, maxRequiredLength, level, 3);

        }

        return output;
    }

    private void checkCandidate(StringBuilder candidate,
                                String s,
                                List<String> output,
                                LinkedList<StringBuilder> stack,
                                LinkedList<Integer> nodeLevelStack,
                                int len,
                                int actualLength,
                                int maxRequiredLength,
                                int level,
                                int appendLen) {
        if (actualLength + appendLen -1 < len && len - (actualLength + appendLen) <= maxRequiredLength - 3) {
            StringBuilder child = new StringBuilder(candidate);
            String temp = level == 3 ? s.substring(actualLength) : s.substring(actualLength, actualLength + appendLen);
            if (!(temp.length() > 1 && temp.charAt(0) == '0') && Integer.valueOf(temp) <= 255) {
                child.append(temp);
                if (level == 3) {
                    output.add(child.toString());
                } else {
                    child.append(".");
                    stack.push(child);
                    nodeLevelStack.push(level + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution93 solution = new Solution93();
        System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.restoreIpAddresses("5555"));
        System.out.println(solution.restoreIpAddresses("010010"));
    }

}
