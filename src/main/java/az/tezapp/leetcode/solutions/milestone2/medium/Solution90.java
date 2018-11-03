package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution90 {

    // ACCEPTED TODO:[optimize]
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        LinkedList<List<Integer>> queue = new LinkedList<>();
        queue.addFirst(new ArrayList<>());
        Set<List<Integer>> out = new HashSet<>();

        for (int i = 0; i < len; i++) {
            int tmp = nums[i];

            int queueSize = queue.size();
            while (queueSize > 0) {

                List<Integer> data = queue.removeLast();

                List<Integer> dataAdded = new ArrayList<>(data);
                dataAdded.add(tmp);

                queue.addFirst(data);
                queue.addFirst(dataAdded);
                queueSize--;

            }
        }

        while (!queue.isEmpty()) {
            out.add(queue.pop());
        }

        return new ArrayList<>(out);
    }

}
