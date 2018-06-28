package az.tezapp.leetcode.solutions.hard;

public class Solution42 {

    // ACCEPTED - 17% // TODO: optimize it
    public int trap(int[] height) {

        int len = height.length;

        if (len <= 2) {
            return 0;
        }

        boolean modified = false;
        int sum = 0;
        int leftEdge = height[0] > height[1] ? 0 : -1;
        for (int i = 1; i < len - 1; i++) {
            if ((height[i - 1] <= height[i] && height[i] > height[i + 1]) ||
                    (height[i - 1] < height[i] && height[i] >= height[i + 1])){
                if (leftEdge != -1) {
                    int tmpSum = calculateSum(leftEdge, i, height);
                    if (tmpSum != 0) {
                        sum += tmpSum;
                        modified = true;
                    }
                }
                leftEdge = i;
            }
        }

        if (leftEdge != -1 && height[len - 1] > height[len - 2]) {
            int tmpSum = calculateSum(leftEdge, len - 1, height);
            if (tmpSum != 0) {
                sum += tmpSum;
                modified = true;
            }
        }

        return modified ? sum + trap(height) : sum;
    }

    private int calculateSum(int from, int to, int[] height) {
        int s = 0;
        int min = height[from] < height[to] ? height[from] : height[to];
        for (int i = from; i <= to; i++) {
            if (min > height[i]) {
                s += min - height[i];
                height[i] = min;
            }
        }
        return s;
    }

}
