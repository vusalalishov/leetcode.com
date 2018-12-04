package az.tezapp.leetcode.solutions.milestone2.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution128 {

    // ACCEPTED - 8% [TODO: review solution]
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<Set<Integer>> sequenceList = new ArrayList<>();
        for (int num : nums) {
            int leftNum = num - 1;
            int rightNum = num + 1;
            int leftIndex = -1;
            int rightIndex = -1;
            for (int i = 0; i < sequenceList.size(); i++) {
                Set<Integer> dataSet = sequenceList.get(i);
                if (dataSet.contains(leftNum)) {
                    leftIndex = i;
                }
                if (dataSet.contains(rightNum)) {
                    rightIndex = i;
                }
            }
            if (leftIndex == -1 && rightIndex == -1) {
                Set<Integer> data = new HashSet<>();
                data.add(num);
                sequenceList.add(data);
            } else if (leftIndex != -1 && rightIndex != -1) {
                sequenceList.get(leftIndex).add(num);
                if (leftIndex != rightIndex) {
                    sequenceList.get(leftIndex).addAll(sequenceList.get(rightIndex));
                    sequenceList.remove(rightIndex);
                }
            } else if (leftIndex != -1) {
                sequenceList.get(leftIndex).add(num);
            } else {
                sequenceList.get(rightIndex).add(num);
            }
        }
        return sequenceList.stream().mapToInt(Set::size).max().orElse(-1);
    }

}
