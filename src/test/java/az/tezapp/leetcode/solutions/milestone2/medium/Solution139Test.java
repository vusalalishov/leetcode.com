package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution139Test {

    private Solution139 subject = new Solution139();

    @Test
    void testWordBreak() {
//        assertThat(subject.wordBreak("a", Arrays.asList("a"))).isTrue();
        assertThat(subject.wordBreak("ccbb", Arrays.asList("bc", "cb"))).isFalse();
        assertThat(subject.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aa"))).isFalse();
        assertThat(subject.wordBreak("a", Arrays.asList("b"))).isFalse();
        assertThat(subject.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))).isFalse();
        assertThat(subject.wordBreak("applepenapple", Arrays.asList("apple", "pen"))).isTrue();
        assertThat(subject.wordBreak("leetcode", Arrays.asList("leet", "code"))).isTrue();
        assertThat(subject.wordBreak("applepend", Arrays.asList("applepend", "apple", "pend"))).isTrue();
    }

}
