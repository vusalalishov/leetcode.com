package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.Arrays;

import static java.lang.String.format;
import org.junit.jupiter.api.Test;

class Solution130Test {

    private Solution130 subject = new Solution130();

    @Test
    void testSolve() {
        char[][] board = new char[][] {
                {'X','O','O','X','X','X','O','X','X','O','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','X','X','O','O','X','O','O','O','X','O','X','O','X','O','O','X','O'},
                {'O','O','O','X','X','X','X','O','X','O','X','X','O','O','O','O','X','O','X','O'},
                {'O','O','O','X','X','O','O','X','O','O','O','X','X','X','O','O','X','O','O','X'},
                {'O','O','O','O','O','O','O','X','X','X','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','O','O','X','O','X','O','X','X','O','O','O','O','O','O','X','O','X'},
                {'O','O','O','X','O','O','O','X','O','X','O','X','O','X','O','X','O','X','O','X'},
                {'O','O','O','X','O','X','O','O','X','X','O','X','O','X','X','O','X','X','X','O'},
                {'O','O','O','O','X','O','O','X','X','O','O','O','O','X','O','O','O','X','O','X'},
                {'O','O','X','O','O','X','O','O','O','O','O','X','O','O','X','O','O','O','X','O'},
                {'X','O','O','X','O','O','O','O','O','O','O','X','O','O','X','O','X','O','X','O'},
                {'O','X','O','O','O','X','O','X','O','X','X','O','X','X','X','O','X','X','O','O'},
                {'X','X','O','X','O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','X'},
                {'O','X','O','O','X','X','X','O','O','O','X','X','X','X','X','O','X','O','O','O'},
                {'O','O','X','X','X','O','O','O','X','X','O','O','O','X','O','X','O','O','O','O'},
                {'X','O','O','X','O','X','O','O','O','O','X','O','O','O','X','O','X','O','X','X'},
                {'X','O','X','O','O','O','O','O','O','X','O','O','O','X','O','X','O','O','O','O'},
                {'O','X','X','O','O','O','X','X','X','O','X','O','X','O','X','X','X','X','O','O'},
                {'O','X','O','O','O','O','X','X','O','O','X','O','X','O','O','X','O','O','X','X'},
                {'O','O','O','O','O','O','X','X','X','X','O','X','O','O','O','X','X','O','O','O'}
        };
        print(board);
        subject.solve(board);
        print(board,new char[][] {
                {'X','O','O','X','X','X','O','X','X','O','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','X','X','O','O','X','O','O','O','X','O','X','O','X','O','O','X','O'},
                {'O','O','O','X','X','X','X','O','X','O','X','X','O','O','O','O','X','O','X','O'},
                {'O','O','O','X','X','O','O','X','O','O','O','X','X','X','O','O','X','O','O','X'},
                {'O','O','O','O','O','O','O','X','X','X','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','O','O','X','O','X','O','X','X','O','O','O','O','O','O','X','O','X'},
                {'O','O','O','X','O','O','O','X','O','X','O','X','O','X','O','X','O','X','O','X'},
                {'O','O','O','X','O','X','O','O','X','X','O','X','O','X','X','O','X','X','X','O'},
                {'O','O','O','O','X','O','O','X','X','O','O','O','O','X','O','O','O','X','O','X'},
                {'O','O','X','O','O','X','O','O','O','O','O','X','O','O','X','O','O','O','X','O'},
                {'X','O','O','X','O','O','O','O','O','O','O','X','O','O','X','O','X','O','X','O'},
                {'O','X','O','O','O','X','O','X','O','X','X','O','X','X','X','O','X','X','O','O'},
                {'X','X','O','X','O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','X'},
                {'O','X','O','O','X','X','X','O','O','O','X','X','X','X','X','O','X','O','O','O'},
                {'O','O','X','X','X','O','O','O','X','X','O','O','O','X','O','X','O','O','O','O'},
                {'X','O','O','X','O','X','O','O','O','O','X','O','O','O','X','O','X','O','X','X'},
                {'X','O','X','O','O','O','O','O','O','X','O','O','O','X','O','X','O','O','O','O'},
                {'O','X','X','O','O','O','X','X','X','O','X','O','X','O','X','X','X','X','O','O'},
                {'O','X','O','O','O','O','X','X','O','O','X','O','X','O','O','X','O','O','X','X'},
                {'O','O','O','O','O','O','X','X','X','X','O','X','O','O','O','X','X','O','O','O'}
        });

    }

    void print(char[][] board1, char[][] board2) {
        System.out.println();
        for (int i = 0; i < board1.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board1[0].length; j++) {
                System.out.print(format("%3s", board1[i][j] == board2[i][j] ? board2[i][j] : "R" ) + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    void print(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

}
