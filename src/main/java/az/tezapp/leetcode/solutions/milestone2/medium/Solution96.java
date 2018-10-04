package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution96 {

    // ACCEPTED - 100%
    public int numTrees(int n) {

        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(5);
        for (int i = 4; i <= n; i++) {
            int j = 1;
            int s = 0;
            while (j <= i) {
                int left = j > 2 ? data.get(j - 1 - 1) : 1;
                int right = i - j > 1 ? data.get(i - j - 1) : 1;
                s += left * right;
                j++;
            }
            data.add(s);
        }

        return data.get(n - 1);
    }

}
