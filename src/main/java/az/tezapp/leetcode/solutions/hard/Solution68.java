package az.tezapp.leetcode.solutions.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution68 {

    // ACCEPTED - 35%
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<Integer> spaceCount = new ArrayList<>();
        Map<Integer, List<String>> wordPerLine = new HashMap<>();

        int letterCount = 0;
        int lineIndex = 0;
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i];
            int len = tmp.length();
            if (letterCount == 0) {
                wordPerLine.putIfAbsent(lineIndex, new ArrayList<>());
                wordPerLine.get(lineIndex).add(tmp);
                letterCount += len;
            } else {
                if (maxWidth - (letterCount + 1) >= len) {
                    wordPerLine.get(lineIndex).add(tmp);
                    letterCount += len + 1;
                } else {
                    int spaceInLineCount = wordPerLine.get(lineIndex).size() - 1;
                    letterCount -= spaceInLineCount;

                    spaceCount.add(maxWidth - letterCount);

                    lineIndex++;
                    letterCount = 0;

                    i--;
                }
            }
        }

        int spaceInLineCount = wordPerLine.get(lineIndex).size() - 1;
        letterCount -= spaceInLineCount;

        spaceCount.add(maxWidth - letterCount);

        List<String> output = new ArrayList<>();
        for (int i = 0; i < spaceCount.size(); i++) {
            int availableSpace = spaceCount.get(i);
            int wordCount = wordPerLine.get(i).size();
            StringBuilder sb = new StringBuilder();

            if (i != spaceCount.size() - 1) {
                // regular line
                String[] spaces = calculateSpaces(wordCount, availableSpace);
                int spaceIndex = 0;
                for (int j = 0; j < wordCount; j++) {
                    if (j == wordCount - 1) {
                        sb.append(wordPerLine.get(i).get(j));
                        if (spaceIndex < spaces.length) {
                            sb.append(spaces[spaceIndex]);
                        }
                    } else {
                        sb.append(wordPerLine.get(i).get(j));
                        sb.append(spaces[spaceIndex]);
                        spaceIndex++;
                    }
                }
            } else {
                // last line
                for (int j = 0; j < wordCount; j++) {
                    if (j == wordCount - 1) {
                        sb.append(wordPerLine.get(i).get(j));
                    } else {
                        sb.append(wordPerLine.get(i).get(j));
                        sb.append(" ");
                        availableSpace--;
                    }
                }
                sb.append(buildSpaces(availableSpace));
            }
            output.add(sb.toString());
        }

        return output;
    }

    private String[] calculateSpaces(int wordCount, int availableSpace) {
        if (wordCount == 1) {
            String[] spaces = new String[1];
            spaces[0] = buildSpaces(availableSpace);
            return spaces;
        }

        int initialSpaceCount = availableSpace / (wordCount - 1);
        int leftSpaceCount = availableSpace % (wordCount - 1);
        int[] out = new int[wordCount - 1];
        int wIndex = 0;
        for (int i = 0; i < leftSpaceCount; i++) {
            out[wIndex]++;
            wIndex++;
        }
        String[] spaces = new String[wordCount - 1];
        for (int i = 0; i < wordCount - 1; i++) {
            out[i] += initialSpaceCount;
            spaces[i] = buildSpaces(out[i]);
        }
        return spaces;
    }

    private Map<Integer, String> spaceCache = new HashMap<>();

    private String buildSpaces(int count) {
        if (spaceCache.containsKey(count)) {
            return spaceCache.get(count);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append(" ");
            }
            spaceCache.put(count, sb.toString());
            return sb.toString();
        }
    }

}
