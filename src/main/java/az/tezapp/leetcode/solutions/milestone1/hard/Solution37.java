package az.tezapp.leetcode.solutions.milestone1.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution37 {

    private static final int BOARD_SIZE = 9;
    private static final int BOX_SIZE = 3;

    // ACCEPTED - 10% [TODO: optimize it and cleanup]
    public void solveSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> boxes = new HashMap<>();

        // fill initial data
        for (int row = 0; row < BOARD_SIZE; row++) {
            rows.putIfAbsent(row, new HashSet<>());
            for (int col = 0; col < BOARD_SIZE; col++) {
                cols.putIfAbsent(col, new HashSet<>());
                int boxNumber = boxNumber(row, col);
                boxes.putIfAbsent(boxNumber, new HashSet<>());
                char tmpVal = board[row][col];
                if (isNotDot(tmpVal)) {
                    int num = toInt(tmpVal);
                    rows.get(row).add(num);
                    cols.get(col).add(num);
                    boxes.get(boxNumber).add(num);
                }
            }
        }

        solveIt(board, 0, 0, rows, cols, boxes);

    }

    private boolean solveIt(char[][] board,
                            int row,
                            int col,
                            Map<Integer, Set<Integer>> rows,
                            Map<Integer, Set<Integer>> cols,
                            Map<Integer, Set<Integer>> boxes) {

        if (row == (BOARD_SIZE - 1) && col == (BOARD_SIZE - 1)) {
            if (isNotDot(board[row][col])) {
                return true;
            } else {
                int boxNumber = boxNumber(row, col);

                Set<Integer> rowSet = rows.get(row);
                Set<Integer> colSet = cols.get(col);
                Set<Integer> boxSet = boxes.get(boxNumber);

                Set<Integer> busyValues = new HashSet<>();
                busyValues.addAll(rowSet);
                busyValues.addAll(colSet);
                busyValues.addAll(boxSet);
                for (int i = 1; i <= 9; i++) {
                    if (!busyValues.contains(i)) {
                        board[row][col] = toChar(i);
                        return true;
                    }
                }
            }
            // You may assume that the given Sudoku puzzle will have a single unique solution.
            return false;
        }

        int[] rowCol = nextRowCol(row, col);

        char currentVal = board[row][col];
        if (isNotDot(currentVal)) {
            return solveIt(board, rowCol[0], rowCol[1], rows, cols, boxes);
        } else {

            int boxNumber = boxNumber(row, col);

            Set<Integer> rowSet = rows.get(row);
            Set<Integer> colSet = cols.get(col);
            Set<Integer> boxSet = boxes.get(boxNumber);

            Set<Integer> busyValues = new HashSet<>();
            busyValues.addAll(rowSet);
            busyValues.addAll(colSet);
            busyValues.addAll(boxSet);

            int prevVal = -1;
            for (int i = 1; i <= 9; i++) {
                if (!busyValues.contains(i)) {
                    if (prevVal != -1) {
                        rowSet.remove(prevVal);
                        colSet.remove(prevVal);
                        boxSet.remove(prevVal);
                        busyValues.remove(prevVal);
                    }
                    prevVal = i;
                    busyValues.add(i);
                    rowSet.add(i);
                    colSet.add(i);
                    boxSet.add(i);

                    board[row][col] = toChar(i);

                    boolean b = solveIt(board, rowCol[0], rowCol[1], rows, cols, boxes);
                    if (b) {
                        return true;
                    }

                }
            }

            if (prevVal != -1) {
                rowSet.remove(prevVal);
                colSet.remove(prevVal);
                boxSet.remove(prevVal);
                busyValues.remove(prevVal);
            }

            board[row][col] = '.';

            return false;
        }
    }

    private int boxNumber(int row, int col) {
        return (row / BOX_SIZE) * BOX_SIZE + col / BOX_SIZE;
    }

    private int[] nextRowCol(int row, int col) {
        col++;
        row += col / BOARD_SIZE;
        col = col % BOARD_SIZE;
        return new int[] {row, col};
    }

    private boolean isNotDot(char c) {
        return c != '.';
    }

    private int toInt(char source) {
        return source - 48;
    }

    private char toChar(int source) {
        return (char) (source + 48);
    }

}
