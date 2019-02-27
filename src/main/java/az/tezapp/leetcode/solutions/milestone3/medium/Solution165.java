package az.tezapp.leetcode.solutions.milestone3.medium;

public class Solution165 {

    // ACCEPTED - 100%
    public int compareVersion(String version1, String version2) {

        int l1 = version1.length();
        int l2 = version2.length();

        int i1 = 0;
        int i2 = 0;

        while (i1 < l1 && i2 < l2) {

            int num1 = 0;
            while (i1 < l1 && version1.charAt(i1) != '.') {
                num1 = num1 * 10 + version1.charAt(i1) - 48;
                i1++;
            }

            int num2 = 0;
            while (i2 < l2 && version2.charAt(i2) != '.') {
                num2 = num2 * 10 + version2.charAt(i2) - 48;
                i2++;
            }

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
            i1++;
            i2++;

        }

        if (i1 < l1) {
            int num1 = 0;
            while (i1 < l1) {
                while (i1 < l1 && version1.charAt(i1) != '.') {
                    num1 = num1 * 10 + version1.charAt(i1) - 48;
                    i1++;
                }
                if (num1 > 0) {
                    return 1;
                }
                i1++;
            }
        }

        if (i2 < l2) {
            int num2 = 0;
            while (i2 < l2) {
                while (i2 < l2 && version2.charAt(i2) != '.') {
                    num2 = num2 * 10 + version2.charAt(i2) - 48;
                    i2++;
                }
                if (num2 > 0) {
                    return -1;
                }
                i2++;
            }
        }

        return 0;
    }

}
