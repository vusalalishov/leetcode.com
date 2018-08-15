package az.tezapp.leetcode.solutions.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution60 {

    // ACCEPTED: 30% [todo: optimize it]
    public String getPermutation(int n, int k) {
        StringBuilder out = new StringBuilder();
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            data.add(i);
        }
        getPermutation(n, k, out, data);
        return out.toString();
    }

    private void getPermutation(int n, int k, StringBuilder out, List<Integer> data) {

        if (k == 0) {
            int index = data.size() - 1;
            out.append(data.get(index));
            data.remove(index);
        } else {
            int factorial = 1;
            for (int i = 2; i <= n; i++) {
                factorial *= i;
            }

            int part = factorial / n;

            int item = (int)Math.ceil(k / (part * 1.0));
            out.append(data.get(item - 1));
            data.remove(item - 1);
            k -= part * (k / part);
        }

        n--;
        if (n > 0) {
            getPermutation(n, k, out, data);
        }
    }

}
