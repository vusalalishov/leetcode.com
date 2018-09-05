package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution77 {

    // ACCEPTED - 74%
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return Collections.emptyList();
        }
        LinkedList<List<Integer>> stack = new LinkedList<>();
        for (int i = 1; i <= n - k + 1; i++) {
            stack.addFirst(new ArrayList<>(Collections.singletonList(i)));
        }

        List<List<Integer>> output = new ArrayList<>();
        while (!stack.isEmpty()) {
            List<Integer> comb = stack.removeFirst();
            if (comb.size() == k) {
                output.add(comb);
                continue;
            }
            Integer from = comb.get(comb.size() - 1);
            for (int i = from + 1; i <= n; i++) {
                if (!comb.contains(i) && comb.size() + n - i + 1> k) {
                    ArrayList<Integer> tmp = new ArrayList<>(comb);
                    tmp.add(i);
                    stack.addFirst(tmp);
                } else if (comb.size() + n - i <= k) {
                    ArrayList<Integer> tmp = new ArrayList<>(comb);
                    tmp.add(i);
                    i++;
                    while (i <= n) {
                        tmp.add(i);
                        i++;
                    }
                    stack.addFirst(tmp);
                }
            }
        }

        return output;
    }

}
