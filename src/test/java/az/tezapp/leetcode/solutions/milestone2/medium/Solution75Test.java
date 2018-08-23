package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Solution75Test {

    private Solution75 subject = new Solution75();

    @ParameterizedTest
    @MethodSource("provideArgs")
    void testSortColors(int[] source, int[] expected) {
        subject.sortColors(source);
        assertTrue(Arrays.equals(source, expected));
    }

    private static Stream<Arguments> provideArgs() {
        return Stream.of(
//                Arguments.of(new int[] {2, 0, 2, 1, 1, 0}, new int[] {0, 0, 1, 1, 2, 2}),
                Arguments.of(new int[] {2, 2, 0, 0, 1, 1}, new int[] {0, 0, 1, 1, 2, 2})
//                Arguments.of(new int[] {2, 2, 1, 1, 0, 0}, new int[] {0, 0, 1, 1, 2, 2})
        );
    }

}
