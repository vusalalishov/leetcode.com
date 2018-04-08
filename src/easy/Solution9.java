package easy;

public class Solution9 {

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.isPalindrome3(121));
    }

    // 3%
    public boolean isPalindrome1(int x) {

        if (x < 0) {
            return false;
        }

        int tmp = x;

        int y = tmp % 10;
        tmp /= 10;
        while (tmp != 0) {
            y = y * 10 + tmp % 10;
            tmp /= 10;
        }

        return y == x;
    }

    // 56%
    public boolean isPalindrome2(int x) {

        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        if (x % 10 == 0) {
            return false;
        }

        int numCount = 0;
        int divider = 1;
        while (x > divider) {
            numCount++;
            divider *= 10;
            if (numCount == 10) {
                break;
            }
        }

        int middle = numCount / 2;
        boolean numCountOdd = numCount % 2 != 0;

        int[] stack = new int[11];
        int top = 0;
        int i = 0;
        while (x != 0) {
            if (numCountOdd && i == middle) {
                x /= 10;
                i++;
                continue;
            }
            int token = x % 10;
            x /= 10;
            if (i < middle) {
                stack[top++] = token;
            } else {
                if (stack[top - 1] == token) {
                    top--;
                } else {
                    return false;
                }
            }
            i++;
        }

        return top == 0;

    }

    // 88%
    public boolean isPalindrome3(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        int tmp = 0;
        while (x > tmp) {
            tmp = tmp * 10 + x % 10;
            x /= 10;
        }

        return x == tmp || x == tmp / 10;
    }

}
