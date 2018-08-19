package az.tezapp.leetcode.solutions.milestone1.hard;

import java.util.ArrayList;
import java.util.Arrays;

import az.tezapp.leetcode.solutions.Interval;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution57Test {

    private Solution57 subject = new Solution57();

    @Test
    void testInsert() {

        assertThat(subject.insert(new ArrayList<>(Arrays.asList(
                new Interval(0, 5),
                new Interval(9, 12))
        ), new Interval(7, 16))).isEqualTo(Arrays.asList(
                new Interval(0, 5),
                new Interval(7, 16)
        ));

        assertThat(subject.insert(new ArrayList<>(Arrays.asList(
                new Interval(1, 5))
        ), new Interval(2, 3))).isEqualTo(Arrays.asList(
                new Interval(1, 5)
        ));

        assertThat(subject.insert(new ArrayList<>(Arrays.asList(
                new Interval(1, 3),
                new Interval(6, 9))
        ), new Interval(2, 5))).isEqualTo(Arrays.asList(
                new Interval(1, 5),
                new Interval(6, 9)
        ));

        assertThat(subject.insert(new ArrayList<>(), new Interval(2, 5))).isEqualTo(Arrays.asList(
                new Interval(2, 5)
        ));
    }

}
