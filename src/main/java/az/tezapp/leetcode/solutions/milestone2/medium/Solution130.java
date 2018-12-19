package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.HashSet;
import java.util.Set;

public class Solution130 {

    private static final char O_SIGN = 'O';

    private UF uf;
    private int[][] cluster;
    private Set<Integer> notSurroundedClusters = new HashSet<>();

    // ACCEPTED - 17%
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        cluster = new int[board.length][board[0].length];
        notSurroundedClusters.clear();
        prepareCluster();
        uf = new UF(1000);

        int clusterIndex = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == O_SIGN) {

                    int[] surroundedClusters = loadSurroundedClusters(i, j);
                    if (surroundedClusters[4] == -1) {
                        cluster[i][j] = clusterIndex;
                        clusterIndex++;
                    } else {
                        int neighborCluster = surroundedClusters[surroundedClusters[4]];
                        cluster[i][j] = neighborCluster;
                        for (int k = surroundedClusters[4] + 1; k < 4; k++) {
                            if (surroundedClusters[k] != -1 && neighborCluster != surroundedClusters[k]) {
                                uf.union(neighborCluster, surroundedClusters[k]);
                            }
                        }
                    }

                    if (isBorder(i, board.length, j, board[0].length)) {
                        notSurroundedClusters.add(cluster[i][j]);
                    }
                }
            }
        }

        Set<Integer> tmpNotSurrounded = new HashSet<>();
        for (Integer currentClusterIndex : notSurroundedClusters) {
            for (int i = 1; i < clusterIndex; i++) {
                if (i != currentClusterIndex && uf.connected(i, currentClusterIndex)) {
                    tmpNotSurrounded.add(i);
                }
            }
        }
        notSurroundedClusters.addAll(tmpNotSurrounded);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (cluster[i][j] > 0 && !notSurroundedClusters.contains(cluster[i][j])) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private int[] loadSurroundedClusters(int i, int j) {
        int[] surroundedClusters = new int[5];
        surroundedClusters[0] = topClusterIndex(i, j);
        surroundedClusters[1] = rightClusterIndex(i, j);
        surroundedClusters[2] = bottomClusterIndex(i, j);
        surroundedClusters[3] = leftClusterIndex(i, j);

        int surroundedClusterIndex = 0;
        while (surroundedClusterIndex < surroundedClusters.length - 1) {
            if (surroundedClusters[surroundedClusterIndex] == -1) {
                surroundedClusterIndex++;
            } else {
                break;
            }
        }
        surroundedClusters[4] = surroundedClusterIndex < 4 ? surroundedClusterIndex : -1;
        return surroundedClusters;
    }

    private int leftClusterIndex(int row, int col) {
        return col > 0 ? cluster[row][col - 1] : -1;
    }

    private int bottomClusterIndex(int row, int col) {
        return row < cluster.length - 1 ? cluster[row + 1][col] : -1;
    }

    private int rightClusterIndex(int row, int col) {
        return col < cluster[0].length - 1 ? cluster[row][col + 1] : -1;
    }

    private int topClusterIndex(int row, int col) {
        return row > 0 ? cluster[row - 1][col] : -1;
    }

    private boolean isBorder(int row, int rowMax, int col, int colMax) {
        return row == 0 || row == rowMax - 1 || col == 0 || col == colMax - 1;
    }

    private void prepareCluster() {
        for (int i = 0; i < cluster.length; i++) {
            for (int j = 0; j < cluster[0].length; j++) {
                cluster[i][j] = -1;
            }
        }
    }

    static class UF {

        private int[] tree;

        public UF(int size) {
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

}
