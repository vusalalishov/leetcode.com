package az.tezapp.leetcode.solutions.milestone1.hard;

import java.util.ArrayList;
import java.util.List;

import az.tezapp.leetcode.solutions.Interval;

public class Solution57 {

    // ACCEPTED: 50% [TODO: could be better]
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        if (intervals.isEmpty()) {
            intervals.add(newInterval);
            return intervals;
        }

        int pos = 0;
        while (pos < intervals.size() && newInterval.start >= intervals.get(pos).start) {
            pos++;
        }
        intervals.add(pos, newInterval);

        List<Interval> out = new ArrayList<>();
        int prevPos = pos > 0 ? pos - 1 : 0;
        for (int i = 0; i < prevPos; i++) {
            out.add(intervals.get(i));
        }

        Interval base = intervals.get(prevPos);
        int mergePos = prevPos + 1;
        for (; mergePos < intervals.size(); mergePos++) {

            Interval tmpInterval = intervals.get(mergePos);

            if (base.end >= tmpInterval.start) {
                base.end = base.end > tmpInterval.end ? base.end : tmpInterval.end;
            } else {
                out.add(base);
                base = tmpInterval;
            }
        }

        if (base != null) {
            out.add(base);
        }

        return out;
    }

}
