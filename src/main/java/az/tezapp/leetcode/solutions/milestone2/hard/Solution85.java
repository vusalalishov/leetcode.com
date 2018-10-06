package az.tezapp.leetcode.solutions.milestone2.hard;

import java.util.LinkedList;

public class Solution85 {

    // ACCEPTED - [TODO: Solved after discussion! (thanks to idea about histogram)]
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int maxArea = 0;
        int temp[] = new int[matrix[0].length];
        for (int row = 0; row < m; row++) {
            for (int i = 0; i < temp.length; i++) {
                if (matrix[row][i] == '0') {
                    temp[i] = 0;
                } else {
                    temp[i] += 1;
                }
            }
            int area = maxHist(temp);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    private int maxHist(int[] hist) {
        LinkedList<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        int top = 0;
        int areWithTop = 0;
        int i = 0;
        while (i < hist.length) {
            if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i++);
            } else {
                top = stack.pop();
                areWithTop = hist[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

                if (maxArea < areWithTop) {
                    maxArea = areWithTop;
                }
            }
        }

        while (!stack.isEmpty()) {
            top = stack.pop();
            areWithTop = hist[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

            if (maxArea < areWithTop) {
                maxArea = areWithTop;
            }
        }

        return maxArea;
    }

}


