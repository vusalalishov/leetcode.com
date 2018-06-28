package az.tezapp.leetcode.solutions.hard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class Solution42Test {

    private Solution42 subject = new Solution42();

    @Test
    void testTrap() {
        assertThat(subject.trap(new int[]{4,2,3})).isEqualTo(1);
        assertThat(subject.trap(new int[]{5,3,7,7})).isEqualTo(2);
        assertThat(subject.trap(new int[]{8,2,8,9,0,1,7,7,9})).isEqualTo(27);
        assertThat(subject.trap(new int[]{2,0,2})).isEqualTo(2);
        assertThat(subject.trap(new int[]{2,8,5,5,6,1,7,4,5})).isEqualTo(12);
        assertThat(subject.trap(new int[]{9,6,8,8,5,6,3})).isEqualTo(3);
        assertThat(subject.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})).isEqualTo(6);
        assertThat(subject.trap(new int[]{})).isEqualTo(0);
        assertThat(subject.trap(new int[]{1,2})).isEqualTo(0);
        assertThat(subject.trap(new int[]{1})).isEqualTo(0);
        assertThat(subject.trap(new int[]{1,7,8})).isEqualTo(0);
        assertThat(subject.trap(new int[]{5,2,1,2,1,5})).isEqualTo(14);
        assertThat(subject.trap(new int[]{4,9,4,5,3,2})).isEqualTo(1);
    }

}
