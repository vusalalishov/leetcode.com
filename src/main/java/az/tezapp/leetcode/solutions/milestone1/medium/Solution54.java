package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution54 {

    enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    private Direction direction = Direction.RIGHT;

    // 20% - ACCEPTED [TODO: optimize it]
    public List<Integer> spiralOrder(int[][] matrix) {

        int rowCount = matrix.length;
        if (rowCount == 0) {
            return Collections.emptyList();
        }
        int colCount = matrix[0].length;
        int allCount = rowCount * colCount;

        int[][] markerMatrix = new int[rowCount][colCount];

        int row = 0;
        int col = 0;
        List<Integer> target = new ArrayList<>();
        addToTarget(target, row, col, matrix, markerMatrix);
        while (target.size() < allCount) {
            int[] nextRowCol = getNextItem(row, col, markerMatrix);
            row = nextRowCol[0];
            col = nextRowCol[1];
            addToTarget(target, row, col, matrix, markerMatrix);
        }

        return target;
    }

    private void addToTarget(List<Integer> target, int row, int col, int[][] matrix, int[][] markerMatrix) {
        target.add(matrix[row][col]);
        markBusy(row, col, markerMatrix);
    }

    private void markBusy(int row, int col, int[][] markerMatrix) {
        markerMatrix[row][col] = 1;
    }

    private int[] getNextItem(int row, int col, int[][] markerMatrix) {
        int rowCount = markerMatrix.length;
        int colCount = markerMatrix[0].length;

        if (direction == Direction.RIGHT) {
            if (col + 1 < colCount && markerMatrix[row][col + 1] != 1) {
                return rowCol(row, col + 1);
            } else {
                direction = Direction.DOWN;
                return getNextItem(row, col, markerMatrix);
            }
        }

        if (direction == Direction.DOWN) {
            if (row + 1 < rowCount && markerMatrix[row + 1][col] != 1) {
                return rowCol(row + 1, col);
            } else {
                direction = Direction.LEFT;
                return getNextItem(row, col, markerMatrix);
            }
        }

        if (direction == Direction.LEFT) {
            if (col - 1 >= 0 && markerMatrix[row][col - 1] != 1) {
                return rowCol(row, col - 1);
            } else {
                direction = Direction.UP;
                return getNextItem(row, col, markerMatrix);
            }
        }

        if (direction == Direction.UP) {
            if (row - 1 >= 0 && markerMatrix[row - 1][col] != 1) {
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
