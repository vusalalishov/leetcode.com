package az.tezapp.leetcode.solutions;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class UnionFindTest {

    private UnionFind subject = new UnionFind(100);

    @Test
    void testUnionAndFind() {
        subject.union(1, 2);
        subject.union(2, 3);
        subject.union(2, 5);
        subject.union(2, 6);
        subject.union(8, 9);
        subject.union(8, 10);
        subject.union(7, 10);
        subject.union(7, 12);
        subject.union(13, 14);
        subject.union(13, 12);
        subject.union(1, 12);

        assertTrue(subject.connected(1, 12));
        assertTrue(subject.connected(1, 2));
        assertTrue(subject.connected(8, 2));
        assertTrue(subject.connected(8, 12));
        assertTrue(subject.connected(8, 13));

    }

}
