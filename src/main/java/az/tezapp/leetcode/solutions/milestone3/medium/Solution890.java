package az.tezapp.leetcode.solutions.milestone3.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution890 {

    public static void main(String[] args) {
        final Solution890 sol = new Solution890();
        System.out.println(
                sol.findAndReplacePattern(new String[] {"a", "a"}, "c")
        );
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        if (words.length == 0 || pattern.isEmpty()) {
            return Collections.emptyList();
        }

        return Stream.of(words)
                .filter(w -> checkByPattern(w, pattern))
                .collect(Collectors.toList());
    }

    private boolean checkByPattern(final String w, final String pattern) {

        if (w.length() != pattern.length()) {
            return false;
        }

        final Set<Character> used = new HashSet<>();
        final Map<Character, Character> map = new HashMap<>();

        final char[] wChars = w.toCharArray();
        final char[] pChars = pattern.toCharArray();

        for (int i = 0; i < wChars.length; i++) {
            if (map.containsKey(wChars[i])) {
                if (map.get(wChars[i]) != pChars[i]) {
                    return false;
                }
            } else {
                if (used.contains(pChars[i])) {
                    return false;
                } else {
                    map.put(wChars[i], pChars[i]);
                    used.add(pChars[i]);
                }
            }
        }
        return true;
    }

}
