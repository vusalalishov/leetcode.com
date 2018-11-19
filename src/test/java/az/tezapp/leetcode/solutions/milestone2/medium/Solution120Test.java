package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Solution120Test {

    private Solution120 subject = new Solution120();

    @Test
    void testMinimumTotal() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int minimumTotal = subject.minimumTotal(triangle);
        assertEquals(11, minimumTotal);
    }

}
