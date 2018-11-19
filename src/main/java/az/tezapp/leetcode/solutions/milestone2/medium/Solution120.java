package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.List;

public class Solution120 {

    // ACCEPTED - 57%
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.get(triangle.size() - 1).size();
        int[] buffer = new int[len];
        int[] helperBuffer = new int[len];
        buffer[0] = triangle.get(0).get(0);
        helperBuffer[0] = triangle.get(0).get(0);
        for (int j = 1; j < triangle.size(); j++) {
            List<Integer> row = triangle.get(j);
            for (int i = 0; i < row.size(); i++) {
                int leftIndex = i - 1;
                int leftVal = leftIndex >= 0 ? buffer[leftIndex] + row.get(i) : Integer.MAX_VALUE;
                int rightVal = i < row.size() - 1 ? buffer[i] + row.get(i) : Integer.MAX_VALUE;
                helperBuffer[i] = Math.min(leftVal, rightVal);
            }
            System.arraycopy(helperBuffer, 0, buffer, 0, j + 1);
        }
        int min = buffer[0];
        for (int i = 1; i < buffer.length; i++) {
            min = Math.min(min, buffer[i]);
        }
        return min;
    }

}
