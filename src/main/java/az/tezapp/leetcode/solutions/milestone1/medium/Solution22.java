package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution22 {

    // TODO: to be optimized
    // ACCPETED - 7%
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        List<String> out = new ArrayList<>();
        List<String> comb = comb(n * 2, 1, 1, 0);
        for (int i = 0; i < comb.size(); i++) {
            out.add("(" + comb.get(i));
        }
        return out;
    }

    private List<String> comb(int n, int i, int openCount, int closeCount) {

        if (i == n - 1) {
            return Collections.singletonList(")");
        }

        int tillEnd = n - i - 1;
        List<String> out = new ArrayList<>();
        if (openCount >= closeCount) {
            int diff = openCount - closeCount;
            if ((openCount > closeCount && diff < tillEnd) || openCount == closeCount) {
                List<String> comb2 = comb(n, i + 1, openCount + 1, closeCount);
                if (comb2.isEmpty()) {
                    out.add("(");
                } else {
                    for (String s : comb2) {
                        out.add("(" + s);
                    }
                }
            }

            if (openCount > closeCount) {
                List<String> comb1 = comb(n, i + 1, openCount, closeCount + 1);
                if (comb1.isEmpty()) {
                    out.add(")");
                } else {
                    for (String s : comb1) {
                        out.add(")" + s);
                    }
                }
            }

        }

        return out;
    }

}
