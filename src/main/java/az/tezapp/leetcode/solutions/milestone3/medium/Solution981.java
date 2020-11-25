package az.tezapp.leetcode.solutions.milestone3.medium;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution981 {

    public static void main(String[] args) {
        final ArrayList<Integer> myList = new ArrayList<>();
        Collections.addAll(myList, 5, 19, 20, 25, 33, 47, 58, 61, 70, 82, 92, 100);
        final int i = Collections.binarySearch(myList, 3);
        System.out.println(myList.get(-i - 1));
    }

}


class TimeMap {

    private final Map<String, List<Pair<Integer, String>>> dataMap;

    /** Initialize your data structure here. */
    public TimeMap() {
        dataMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        dataMap.compute(key, (s, list) -> {
            if (list == null) list = new ArrayList<>();
            list.add(new Pair<>(timestamp, value));
            return list;
        });
    }

    public String get(String key, int timestamp) {
        final List<Pair<Integer, String>> list = dataMap.getOrDefault(key, new ArrayList<>());
        final int i = Collections.binarySearch(list, new Pair<>(timestamp, ""), Comparator.comparing(Pair::getKey));
        if (i >= 0) {
            return list.get(i).getValue();
        } else if (i == -1) {
            return "";
        } else {
            return list.get(-i - 2).getValue();
        }
    }
}