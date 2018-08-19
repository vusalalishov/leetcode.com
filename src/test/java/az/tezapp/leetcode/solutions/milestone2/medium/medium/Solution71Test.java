package az.tezapp.leetcode.solutions.milestone2.medium.medium;

import az.tezapp.leetcode.solutions.milestone2.medium.Solution71;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution71Test {

    private Solution71 subject = new Solution71();

    @Test
    void testSimplifyPath() {
        assertThat(subject.simplifyPath("/..")).isEqualTo("/");
        assertThat(subject.simplifyPath("/home/")).isEqualTo("/home");
        assertThat(subject.simplifyPath("/a/./b/../../c/")).isEqualTo("/c");
        assertThat(subject.simplifyPath("/home//foo/")).isEqualTo("/home/foo");
    }

}
