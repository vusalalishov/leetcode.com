package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Solution81Test {

    private Solution81 subject = new Solution81();

    @ParameterizedTest
    @MethodSource("provideArgs")
    void testSearch(int[] source, int target, boolean expected) {
        assertThat(subject.search(source, target)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgs() {
        return Stream.of(
                Arguments.of(new int[] {0, 1, 1, 2, 3, 0}, 3, true),
                Arguments.of(new int[] {1, 2, 0, 1, 1, 1}, 0, true),
                Arguments.of(new int[] {0, 0, 1, 1, 2, 0}, 2, true),
                Arguments.of(new int[] {0, 0, 1, 2, 0}, 2, true),
                Arguments.of(new int[] {2, 5, 6, 0, 0, 1, 2}, 0, true),
                Arguments.of(new int[] {2, 5, 6, 0, 0, 1, 2}, 3, false),
                Arguments.of(new int[0], 3, false),
                Arguments.of(new int[] {1, 3}, 1, true),
                Arguments.of(new int[] {1, 3}, 3, true),
                Arguments.of(new int[] {1, 1, 1, 3, 1}, 3, true),
                Arguments.of(new int[] {1, 1, 1, 3, 1}, 1, true),
                Arguments.of(new int[] {1, 1, 1, 3, 1}, 5, false),
                Arguments.of(new int[] {1, 3, 1, 1, 1}, 1, true),
                Arguments.of(new int[] {1, 3, 1, 1, 1}, 3, true),
                Arguments.of(new int[] {1, 1, 1, 3, 1}, 3, true),
                Arguments.of(new int[] {1, 3, 1, 1, 1}, 5, false)
        );
    }

}
