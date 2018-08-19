package az.tezapp.leetcode.solutions.milestone1.hard;

import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution45Test {

    private Solution45 subject = new Solution45();

    @Test
    void testJump() {
        assertThat(subject.jump(new int[] {5,9,3,2,1,0,2,3,3,1,0,0})).isEqualTo(3);
        assertThat(subject.jump(new int[] {2,3,1,1,4})).isEqualTo(2);
        assertThat(subject.jump(new int[] {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3})).isEqualTo(2);
        assertThat(subject.jump(new int[] {2,1})).isEqualTo(1);
        assertThat(subject.jump(new int[] {1,2,3})).isEqualTo(2);
        assertThat(subject.jump(new int[] {2,2,1,1,1,1})).isEqualTo(4);
    }

}
