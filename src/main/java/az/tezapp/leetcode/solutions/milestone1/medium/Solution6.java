package az.tezapp.leetcode.solutions.milestone1.medium;

public class Solution6 {

    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
        System.out.println(solution.convert("A", 1));
        System.out.println(solution.convert("AB", 1));
    }

    // beats 76%
    public String convert(String s, int numRows) {
        int len = s.length();
        if (len <= numRows || numRows == 1) {
            return s;
        }

        StringBuilder converted = new StringBuilder("");
        for (int index = 0; index < numRows; index++) {
            int start = index;
            converted.append(s.charAt(index));
            while (true) {
                int first = start + 2 * (numRows - 1 - index);
                int second = first + 2 * index;
                if (first == second || index == numRows - 1) {
                    if (second < len) {
                        converted.append(s.charAt(second));
                        start = second;
                    } else {
                        break;
                    }
                } else {
                    if (first < len) {
                        converted.append(s.charAt(first));
                    } else  {
                        break;
                    }
                    if (second < len) {
                        converted.append(s.charAt(second));
                        start = second;
                    } else {
                        break;
                    }
                }
            }
        }

        return converted.toString();
    }

}
