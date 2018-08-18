package az.tezapp.leetcode.solutions.medium;

import java.util.Deque;
import java.util.LinkedList;

public class Solution71 {

    // ACCEPTED: 93%
    public String simplifyPath(String path) {

        String[] source = path.split("/");
        Deque<String> deque = new LinkedList<>();

        for (String tmp : source) {
            if (tmp.isEmpty() || tmp.equals(".")) {
                continue;
            }
            if (tmp.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeFirst();
                }
                continue;
            }
            deque.addFirst(tmp);
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.removeLast());
        }

        if (sb.length() == 0) {
            sb.append("/");
        }

        return sb.toString();
    }

}
