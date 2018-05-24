package hard;

public class Solution32 {

    private static final char OPEN = '(';

    private static final int OPEN_VAL = -1;
    private static final int CLOSE_VAL = -2;

    public static void main(String[] args) {
        Solution32 solution = new Solution32();
        System.out.println(solution.longestValidParentheses("(())"));
    }

    // TODO: review discussion forum
    // ACCEPTED - 47%
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }

        int[] source = new int[len];
        for (int i = 0; i < len; i++) {
            source[i] = s.charAt(i) == OPEN ? OPEN_VAL : CLOSE_VAL;
        }

        boolean expanded = true;
        while (expanded) {
            expanded = false;

            int openIndex = -1;
            int closeIndex = -1;
            for (int i = 0; i < len; i++) {
                if (source[i] == OPEN_VAL) {
                    openIndex = i;
                }
                if (source[i] == CLOSE_VAL && openIndex != -1) {
                    closeIndex = i;
                    expanded = true;
                    expandAround(source, openIndex, closeIndex);
                }
            }

        }

        int max = 0;
        int tmpMax = 0;
        for (int i = 0; i < len; i++) {
            if (source[i] == 1) {
                tmpMax++;
            } else {
                if (tmpMax > max) {
                    max = tmpMax;
                }
                tmpMax = 0;
            }
        }
        if (tmpMax > max) {
            max = tmpMax;
        }

        return max;
    }

    private void expandAround(int[] source, int from, int to) {
        if (source[from] == OPEN_VAL && source[to] == CLOSE_VAL) {
            source[from] = 1;
            source[to] = 1;
            if (from - 1 > 0 && to + 1 < source.length) {
                expandAround(source, from - 1, to + 1);
            }
        }
    }

}
