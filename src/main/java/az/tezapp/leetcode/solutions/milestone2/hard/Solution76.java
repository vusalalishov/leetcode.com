package az.tezapp.leetcode.solutions.milestone2.hard;

public class Solution76 {

    // ACCEPTED - 54%
    public String minWindow(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        int wLength = -1;
        String output = "";

        int[] expectedCount = formExpectations(t);

        int startPointer = 0;
        int endPointer = 0;
        int[] matchCount = new int[expectedCount.length];
        while (endPointer < sLen) {
            char tmp = s.charAt(endPointer);
            int indexOfTmp = t.indexOf(tmp);
            if (indexOfTmp != -1) {
                matchCount[indexOfTmp]++;

                while (startPointer < endPointer) {
                    char candidate = s.charAt(startPointer);
                    int candidateIndex = t.indexOf(candidate);
                    if (candidateIndex != -1) {
                        if (matchCount[candidateIndex] > expectedCount[candidateIndex]) {
                            matchCount[candidateIndex]--;
                            startPointer++;
                        } else {
                            break;
                        }
                    } else {
                        startPointer++;
                    }
                }

                if (isMatches(matchCount, expectedCount)) {
                    if (wLength == -1 || endPointer - startPointer < wLength) {
                        output = s.substring(startPointer, endPointer + 1);
                        wLength = endPointer - startPointer;
                    }
                }
            }

            endPointer++;
        }

        return output;

    }

    private int[] formExpectations(String t) {
        int len = t.length();

        if (len == 0) {
            return new int[0];
        }

        int[] expectation = new int[len];
        int lastIndex = -1;
        for (int i = 0; i < len; i++) {
            char tmp = t.charAt(i);
            int tmpIndex = t.indexOf(tmp);
            expectation[tmpIndex]++;
            if (tmpIndex > lastIndex) {
                lastIndex = tmpIndex;
            }
        }

        int[] out = new int[lastIndex + 1];
        System.arraycopy(expectation, 0, out, 0, lastIndex + 1);
        return out;
    }

    private boolean isMatches(int[] matchCount, int[] expected) {
        for (int i = 0; i < matchCount.length; i++) {
            if (matchCount[i] < expected[i]) {
                return false;
            }
        }
        return true;
    }

}
