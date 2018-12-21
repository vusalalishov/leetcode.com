package az.tezapp.leetcode.solutions.milestone2.easy;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Solution125Test {

    private Solution125 subject = new Solution125();

    @Test
    void testIsPalindrome() {
//        assertThat(subject.isPalindrome("abb")).isFalse();
//        assertThat(subject.isPalindrome("aba")).isTrue();
//        assertThat(subject.isPalindrome("aa")).isTrue();
//        assertThat(subject.isPalindrome("abadaba")).isTrue();
//        assertThat(subject.isPalindrome("abadabadaba")).isTrue();
        assertThat(subject.isPalindrome("A man, a plan, a canal: Panama")).isTrue();
        assertThat(subject.isPalindrome("A")).isTrue();
        assertThat(subject.isPalindrome("")).isTrue();
    }

}
