package az.tezapp.leetcode.solutions.milestone3.medium;

import java.util.LinkedList;
import java.util.List;

public class Solution179 {

    // ACCEPTED - 68%
    public String largestNumber(int[] nums) {

        heapSort(nums);

        if (nums[0] == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (int num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }

    private void heapSort(int[] source) {
        int lastElement = source.length - 1;
        heapify(source);
        while (lastElement > 0) {
            swap(source, 0, lastElement);
            lastElement--;
            sink(source, lastElement, 0);
        }
    }

    private boolean more(int[] source, int lastElement, int a, int b) {
        if (a > lastElement || b > lastElement) {
            return true;
        }
        return compare(source[a], source[b]) >= 0;
    }

    private void sink(int[] source, int lastElement, int index) {
        while ((2 * index + 1) <= lastElement) {
            int k = 2 * index + 1;
            if (k < lastElement && more(source, lastElement, k, k + 1)) {
                k++;
            }
            if (more(source, lastElement, k, index)) {
                break;
            }
            swap(source, index, k);
            index = k;
        }
    }

    private void heapify(int[] source) {
        for (int i = (source.length - 1) / 2; i >= 0; i--) {
            sink(source, source.length - 1, i);
        }
    }

    private void swap(int[] source, int index1, int index2) {
        int tmpVal = source[index1];
        source[index1] = source[index2];
        source[index2] = tmpVal;
    }

    private int compare(int a, int b) {
        if (a == b) {
            return 0;
        }

        if (a == 0) {
            return -1;
        } else if (b == 0) {
            return 1;
        }

        List<Integer> digitsA = getDigits(a);
        List<Integer> digitsB = getDigits(b);
        digitsA.addAll(digitsB);
        digitsB.addAll(digitsA);

        int index = 0;

        while (index < digitsA.size()) {
            if (digitsA.get(index) > digitsB.get(index)) {
                return 1;
            } else if (digitsA.get(index) < digitsB.get(index)) {
                return -1;
            }
            index++;
        }
        return 0;
    }

    private List<Integer> getDigits(int n) {
        LinkedList<Integer> digits = new LinkedList<>();
        while (n > 0) {
            digits.addFirst(n % 10);
            n /= 10;
        }
        return digits;
    }

}
