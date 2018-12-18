package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution127 {

    private Set<String> cache = new HashSet<>();
    private Map<String, List<String>> transformationCache = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> list = new HashSet<>(wordList);
        list.add(beginWord);
        return ladderLengthCustom(endWord, beginWord, list);
    }

    public int ladderLengthCustom(String beginWord, String endWord, Set<String> wordList) {
        cache.clear();
        transformationCache.clear();

        LinkedList<String> wordQueue = new LinkedList<>();
        wordQueue.addFirst(beginWord);
        LinkedList<Integer> usedWordCountQueue = new LinkedList<>();
        usedWordCountQueue.addFirst(1);
        while (!wordQueue.isEmpty()) {
            String word = wordQueue.removeLast();
            int usedWordCount = usedWordCountQueue.removeLast();
            List<String> possibleWords = findPossibleTransformationsFor(word, wordList);
            for (String newWord : possibleWords) {
                if (newWord.equals(endWord)) {
                    return usedWordCount + 1;
                }
                String key = word + newWord;
                if (cache.contains(key)) {
                    continue;
                }
                cache.add(key);
                wordQueue.addFirst(newWord);
                usedWordCountQueue.addFirst(usedWordCount + 1);
            }
        }
        return 0;
    }

    private List<String> findPossibleTransformationsFor(String word, Set<String> wordList) {
        if (transformationCache.containsKey(word)) {
            return transformationCache.get(word);
        }

        List<String> possibleWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String possibleWord = new String(chars);
                if (wordList.contains(possibleWord)) {
                    possibleWords.add(possibleWord);
                }
            }
        }
        transformationCache.put(word, possibleWords);
        return possibleWords;
    }

}
