package medium;

import java.util.Arrays;

public class Solution11 {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int[] sortedHeight = Arrays.copyOf(height, height.length);
        Arrays.sort(sortedHeight);

        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        for (int minHeight : sortedHeight) {
            while (height[start] < minHeight) start++;
            while (height[end] < minHeight) end--;
            if (start == end) {
                continue;
            }
            int tmpArea = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(tmpArea, maxArea);
        }

        return maxArea;
    }

}
