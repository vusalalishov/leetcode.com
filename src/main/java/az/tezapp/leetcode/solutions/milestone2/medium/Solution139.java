package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution139 {

    // ACCEPTED - 64%
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.isEmpty()) {
            return false;
        }
        return wordBreak(s, new HashSet<>(wordDict));
    }

    private boolean wordBreak(String s, Set<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        Iterator<String> wordDictIterator = wordDict.iterator();
        while (wordDictIterator.hasNext()) {
            String tmpS = s;
            String word = wordDictIterator.next();
            int wIndex = tmpS.indexOf(word);
            boolean reduced = false;
            while (wIndex == 0) {
                reduced = true;
                tmpS = tmpS.substring(0, wIndex) + tmpS.substring(wIndex + word.length());
                wIndex = tmpS.indexOf(word);
            }
            if (reduced && wordBreak(tmpS, wordDict)) {
                return true;
            }
        }
        return false;
    }

}
