package az.tezapp.leetcode.solutions.medium;

public class Interval {
    int start = 0;
    int end = 0;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Interval) {
            return ((Interval) obj).start == start && ((Interval) obj).end == end;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return start + end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
