package easy.p7;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse1(123));
    }

    // 55%
    public int reverse1(int x) {

        if (x < 10 & x > -10) {
            return x;
        }

        boolean signed = x < 0;
        long y = x % 10;
        x /= 10;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
            if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
                return 0;
            }
        }
        if (signed && y > 0) {
            y *= -1;
        }
        return (int)y;
    }

    // 66%
    public int reverse2(int x) {

        boolean signed = x < 0;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(signed ? x * -1L : x));
        long y = Long.valueOf(stringBuilder.reverse().toString());
        if (signed) {
            y *= -1;
        }
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)y;
    }

}
