package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.LinkedList;

public class Solution84 {

    public int largestRectangleArea(int[] hist) {
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
