package az.tezapp.leetcode.solutions.medium;

import az.tezapp.leetcode.solutions.milestone1.medium.Solution55;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution55Test {

    private Solution55 subject = new Solution55();

    @Test
    void testCanJump() {
        assertThat(subject.canJump(new int[] {0})).isTrue();
        assertThat(subject.canJump(new int[] {1})).isTrue();
        assertThat(subject.canJump(new int[] {0})).isTrue();
        assertThat(subject.canJump(new int[] {2,3,1,1,4})).isTrue();
        assertThat(subject.canJump(new int[] {3,2,1,0,4})).isFalse();
        assertThat(subject.canJump(new int[] {0,1,1,1,1,1})).isFalse();
        assertThat(subject.canJump(new int[] {0,1,1,0,1,1})).isFalse();
        assertThat(subject.canJump(new int[] {4,1,1,0,1,1})).isTrue();
    }

}
