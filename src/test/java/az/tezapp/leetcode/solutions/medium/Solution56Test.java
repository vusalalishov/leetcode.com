package az.tezapp.leetcode.solutions.medium;

import java.util.Arrays;

import az.tezapp.leetcode.solutions.Interval;
import az.tezapp.leetcode.solutions.milestone1.medium.Solution56;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution56Test {

    private Solution56 subject = new Solution56();

    @Test
    void testMerge() {
        assertThat(subject.merge(Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        ))).isEqualTo(Arrays.asList(
                new Interval(1, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        ));

    }

}
