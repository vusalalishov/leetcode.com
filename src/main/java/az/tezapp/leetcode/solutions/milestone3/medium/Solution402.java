package az.tezapp.leetcode.solutions.milestone3.medium;

public class Solution402 {

    public static void main(String[] args) {
        Solution402 solution402 = new Solution402();
        System.out.println(solution402.removeKdigits("10200", 1));
    }

    // ACCEPTED - 24% - TODO: optimize it - there is no need to start loop from start on each function call
    public String removeKdigits(String num, int k) {
        if (num.length() == k || num.isEmpty()) {
            return "0";
        }
        if (k == 0) {
            return num;
        }

        int indexToBeRemoved = -1;
        for (int i = 1; i < num.length(); i++) {
            int num1 = num.charAt(i - 1) - 48;
            int num2 = num.charAt(i) - 48;
            if (num2 - num1 < 0) {
                indexToBeRemoved = i - 1;
                break;
            }
        }

        indexToBeRemoved = indexToBeRemoved >= 0 ? indexToBeRemoved : num.length() - 1;

        if (indexToBeRemoved == 0) {
            int i = indexToBeRemoved + 1;
            while (i < num.length() && num.charAt(i) == '0') i++;
            return removeKdigits(num.substring(i), k - 1);
        } else {
            if (indexToBeRemoved + 1 < num.length()) {
                return removeKdigits(num.substring(0, indexToBeRemoved) + num.substring(indexToBeRemoved + 1), k - 1);
            } else {
                return removeKdigits(num.substring(0, indexToBeRemoved), k - 1);
            }
        }
    }

}
