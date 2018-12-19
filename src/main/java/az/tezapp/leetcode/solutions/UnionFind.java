package az.tezapp.leetcode.solutions;

public class UnionFind {

    private int[] tree;

    public UnionFind(int size) {
        this.tree = new int[size];
        for (int i = 0; i < size; i++) {
            tree[i] = -1;
        }
    }

    public void union(int a, int b) {
        int ap = findParent(a);
        int bp = findParent(b);
        if (ap == bp) {
            return;
        }
        if (Math.abs(ap) > Math.abs(bp)) {
            tree[bp] = ap;
        } else if (Math.abs(ap) < Math.abs(bp)) {
            tree[ap] = bp;
        } else {
            tree[ap] += tree[bp];
            tree[bp] = ap;
        }
    }

    public boolean connected(int a, int b) {
        int ap = findParent(a);
        int bp = findParent(b);
        return ap == bp;
    }

    private int findParent(int i) {
        return tree[i] < 0 ? i : (tree[i] = findParent(tree[i]));
    }

}
