package az.tezapp.leetcode.solutions.milestone1.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution36 {

    private static final char EMPTY_SYMBOL = '.';
    private static final int BOARD_LENGTH = 9;
    private static final int BOX_LENGTH = BOARD_LENGTH / 3;

    // ACCEPTED - 96%
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> boxes = new HashMap<>();

        for (int row = 0; row < BOARD_LENGTH; row++) {
            rows.putIfAbsent(row, new HashSet<>());
            for (int col = 0; col < BOARD_LENGTH; col++) {
                cols.putIfAbsent(col, new HashSet<>());

                int boardVal = board[row][col];

                if (boardVal == EMPTY_SYMBOL) {
                    continue;
                }

                int boxIndex = (row / BOX_LENGTH) * BOX_LENGTH + (col / BOX_LENGTH);

                boxes.putIfAbsent(boxIndex, new HashSet<>());

                if (rows.get(row).contains(boardVal) ||
                        cols.get(col).contains(boardVal) ||
                        boxes.get(boxIndex).contains(boardVal)) {

                    return false;
                }

                rows.get(row).add(boardVal);
                cols.get(col).add(boardVal);
                boxes.get(boxIndex).add(boardVal);

            }
        }

        return true;
    }

}
