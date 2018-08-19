package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import az.tezapp.leetcode.solutions.Interval;

public class Solution56 {

    // ACCEPTED - 2% [TODO: optimize it (avoid sorting)]
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> out = new ArrayList<>();
        intervals.sort(Comparator.comparingInt(o -> o.start));

        Interval base = null;
        Iterator<Interval> iter = intervals.iterator();
        while (iter.hasNext()) {
            if (base == null) {
                base = iter.next();
                continue;
            }
            Interval curr = iter.next();
            if (base.end >= curr.start) {
                base.end = base.end > curr.end ? base.end : curr.end;
            } else {
                out.add(base);
                base = curr;
            }
        }

        if (base != null) {
            out.add(base);
        }

        return out;
    }

}
