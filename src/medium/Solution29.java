package medium;

public class Solution29 {

    public static void main(String[] args) {
        Solution29 solution = new Solution29();

        System.out.println(solution.divide(-2147483648, 2));
//        System.out.println(Integer.MIN_VALUE - 1);
    }

    // ACCEPTED! Very bad result! To be optimized. Idea - like binary search, searching optimal value for div result
    public int divide(int dividend, int divisor) {

        boolean signed = dividend < 0 ^ divisor < 0;

        if (dividend == divisor || Math.abs(dividend) == Math.abs(divisor)) {
            return fixSign(1, signed);
        }

        if (dividend == 0 || divisor == Integer.MIN_VALUE) {
            return 0;
        }

        if (Math.abs(divisor) == 1) {
            return fixSign(dividend, signed);
        }

        if (Math.abs(dividend) == 1) {
            return 0;
        }

        if (dividend != Integer.MIN_VALUE && Math.abs(dividend) < Math.abs(divisor)) {
            return 0;
        }

        divisor = Math.abs(divisor);

        if (dividend > 0) {
            if (divisor > dividend >> 4) {
                return dividePositiveBig(dividend, divisor, signed);
            } else {
                return dividePositive(dividend, divisor, signed);
            }
        } else {
            if (-divisor < dividend >> 4) {
                return divideNegativeBig(dividend, divisor, signed);
            } else {
                return divideNegative(dividend, divisor, signed);
            }
        }
    }

    private int divideNegativeBig(int dividend, int divisor, boolean signed) {
        int out = 1;
        int sum = -divisor;
        while (sum > dividend) {
            if (notOverflow(sum, -divisor)) {
                sum -= divisor;
                out++;
            } else {
                break;
            }
        }

        if (sum < dividend) {
            out--;
        }

        return fixSign(out, signed);
    }

    private int divideNegative(int dividend, int divisor, boolean signed) {

        int low = dividend;
        int high = 0;
        int middle = (low + high) >> 1;

        int lastMiddle = 0;
        while (low - high < -1) {

            int[] sum = sum(middle, divisor);
            if (sum[0] == 1) {
                low = middle;
            } else {
                if (sum[1] < dividend) {
                    low = middle;
                } else {

                    if (sum[1] == dividend) {
                        return fixSign(middle, signed);
                    }

                    // to right
                    high = middle;
                    if (lastMiddle > middle) {
                        lastMiddle = middle;
                    }
                }
            }

            middle = (low + high) >> 1;
        }

        return fixSign(lastMiddle, signed);
    }

    private int dividePositiveBig(int dividend, int divisor, boolean signed) {
        int out = 1;
        int sum = divisor;
        while (sum < dividend) {
            if (notOverflow(sum, divisor)) {
                sum += divisor;
                out++;
            } else {
                break;
            }
        }

        if (sum > dividend) {
            out--;
        }

        return fixSign(out, signed);
    }

    private int dividePositive(int dividend, int divisor, boolean signed) {

        int low = 0;
        int high = dividend;
        int middle = (low + high) >> 1;

        int lastMiddle = Integer.MIN_VALUE;
        while (high - low > 1) {

            int[] sum = sum(middle, divisor);
            if (sum[0] == 1) {
                high = middle;
            } else {
                if (sum[1] > dividend) {
                    high = middle;
                } else {

                    if (sum[1] == dividend) {
                        return fixSign(middle, signed);
                    }

                    // to right
                    low = middle;
                    if (lastMiddle < middle) {
                        lastMiddle = middle;
                    }
                }
            }

            middle = (low + high) >> 1;
        }

        return fixSign(lastMiddle, signed);
    }

    private int fixSign(int val, boolean signed) {
        if (signed) {
            if (val < 0) {
                return val;
            } else {
                return  -val;
            }
        } else {
            if (val < 0) {
                if (val == Integer.MIN_VALUE) {
                    return Integer.MAX_VALUE;
                } else {
                    return -val;
                }
            }
            return val;
        }
    }

    private boolean notOverflow(int left, int right) {
        return !(right > 0
                        ? Integer.MAX_VALUE - left < right
                        : Integer.MIN_VALUE - left > right);
    }

    private int[] twosComplement = new int[] {
            2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048
    };

    private int[] sum(int token, int count) {
        int out = 0;

        while (count > 1) {
            int twosIndex = twosComplement.length - 1;
            while (twosComplement[twosIndex] > count) {
                twosIndex--;
            }
            int twosComplementVal = twosComplement[twosIndex];
            count -= twosComplementVal;

            int tmpToken = 0;
            for (int i = 0; i < 2 << twosIndex; i += 2) {
                if (notOverflow(tmpToken, token)) {
                    tmpToken += token << 1;
                } else {
                    return sumResponse(true, 0);
                }
            }

            if (notOverflow(out, token << twosIndex + 1)) {
                out += token << twosIndex + 1;
            } else {
                return sumResponse(true, 0);
            }
        }
        if (count == 1) {
            if (notOverflow(out, token)) {
                out += token;
            } else {
                return sumResponse(true, 0);
            }
        }
        return sumResponse(false, out);
    }

    private int[] sumResponse(boolean overflow, int sum) {
        return new int[] {
                overflow ? 1 : 0,
                sum
        };
    }

}
