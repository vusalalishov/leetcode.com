package az.tezapp.leetcode.solutions.milestone2.medium;

public class Solution79 {

    // ACCEPTED - 37% [todo: could be optimized]
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.isEmpty()) {
            return false;
        }
        boolean[][] visitedCells = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (word.indexOf(board[row][col]) == 0) {
                    visitedCells[row][col] = true;
                    boolean b = buildWord(board, row, col, word, 0, visitedCells);
                    if (b) {
                        return true;
                    }
                } else {
                    visitedCells[row][col] = false;
                }
            }
        }
        return false;
    }

    private boolean buildWord(char[][] board, int row, int col, String word, int pointer, boolean[][] visitedCell) {

        int rowCount = board.length;
        int colCount = board[0].length;

        int nextPointer = pointer + 1;
        if (nextPointer >= word.length()) {
            return true;
        }
        char nextChar = word.charAt(nextPointer);

        boolean goUp = row > 0 && !visitedCell[row - 1][col] && board[row - 1][col] == nextChar;
        boolean goRight = col < colCount - 1 && !visitedCell[row][col + 1] && board[row][col + 1] == nextChar;
        boolean goDown = row < rowCount - 1 && !visitedCell[row + 1][col] && board[row + 1][col] == nextChar;
        boolean goLeft = col > 0 && !visitedCell[row][col - 1] && board[row][col - 1] == nextChar;

        visitedCell[row][col] = true;

        boolean b = (goUp && buildWord(board, row - 1, col, word, nextPointer, visitedCell))
                || (goRight && buildWord(board, row, col + 1, word, nextPointer, visitedCell))
                || (goDown && buildWord(board, row + 1, col, word, nextPointer, visitedCell))
                || (goLeft && buildWord(board, row, col - 1, word, nextPointer, visitedCell));
        if (!b) {
            visitedCell[row][col] = false;
            return false;
        } else return true;
    }

}
