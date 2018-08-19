package az.tezapp.leetcode.solutions.milestone1.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Solution91Test {

    private Solution91 solution = new Solution91();

    @ParameterizedTest
    @CsvSource(value = {
            "24726, 4",
            "10, 1",
            "1, 1",
            "12, 2",
            "110, 1",
            "101, 1",
            "200, 0"
    })
    void testNumDecodings(String s, int num) {
        assertEquals(num, solution.numDecodings(s));
    }

}
