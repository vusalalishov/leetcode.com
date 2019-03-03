package az.tezapp.leetcode.solutions.milestone3.medium;

public class Solution151 {

    // ACCEPTED - 92%
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            String w = words[i].trim();
            if (!w.isEmpty()) {
                sb.append(w).append(" ");
            }
        }
        return sb.toString().trim();
    }

}
