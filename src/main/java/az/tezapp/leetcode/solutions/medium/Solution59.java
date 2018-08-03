package az.tezapp.leetcode.solutions.medium;

public class Solution59 {

    enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    private Direction direction = Direction.RIGHT;

    // ACCEPTED - 13% [TODO: optimize]
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }

        int colCount = n;
        int rowCount = n;
        int allCount = n * n;

        int[][] markerMatrix = new int[rowCount][colCount];

        int row = 0;
        int col = 0;
        int i = 0;
        addToTarget(row, col, ++i, markerMatrix);
        while (i < allCount) {
            int[] nextRowCol = getNextItem(row, col, markerMatrix);
            row = nextRowCol[0];
            col = nextRowCol[1];
            addToTarget(row, col, ++i, markerMatrix);
        }

        return markerMatrix;
    }

    private void addToTarget(int row, int col, int val, int[][] markerMatrix) {
        markerMatrix[row][col] = val;
    }

    private int[] getNextItem(int row, int col, int[][] markerMatrix) {
        int rowCount = markerMatrix.length;
        int colCount = markerMatrix[0].length;

        if (direction == Direction.RIGHT) {
            if (col + 1 < colCount && markerMatrix[row][col + 1] == 0) {
                return rowCol(row, col + 1);
            } else {
                direction = Direction.DOWN;
                return getNextItem(row, col, markerMatrix);
            }
        }

        if (direction == Direction.DOWN) {
            if (row + 1 < rowCount && markerMatrix[row + 1][col] == 0) {
                return rowCol(row + 1, col);
            } else {
                direction = Direction.LEFT;
                return getNextItem(row, col, markerMatrix);
            }
        }

        if (direction == Direction.LEFT) {
            if (col - 1 >= 0 && markerMatrix[row][col - 1] == 0) {
                return rowCol(row, col - 1);
            } else {
                direction = Direction.UP;
                return getNextItem(row, col, markerMatrix);
            }
        }

        if (direction == Direction.UP) {
            if (row - 1 >= 0 && markerMatrix[row - 1][col] == 0) {
                return rowCol(row - 1, col);
            } else  {
                direction = Direction.RIGHT;
                return getNextItem(row, col, markerMatrix);
            }
        }

        return new int[0];
    }

    private int[] rowCol(int row, int col) {
        return new int[] {row, col};
    }

}
