package az.tezapp.leetcode.solutions.milestone1.hard;

import java.util.ArrayList;
import java.util.List;

public class Solution45 {

    // ACCEPTED - 3% - TODO: optimize it
    public int jump(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        List<Integer> jumps = new ArrayList<>();
        boolean jumped = false;
        int jumpTo = len - 1;
        while (!jumped) {
            for (int i = 0; i < jumpTo; i++) {
                if (nums[i] >= jumpTo - i) {
                    jumps.add(i);
                    jumpTo = i;
                    break;
                }
            }
            if (jumpTo == 0) {
                jumped = true;
            }
        }
        return jumps.size();
    }

}
