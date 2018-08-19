package az.tezapp.leetcode.solutions.milestone1.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Soution51 {

    // ACCEPTED - 8% [TODO: optimize it]
    public List<List<String>> solveNQueens(int n) {

        if (n == 1) {
            return Arrays.asList(Arrays.asList("Q"));
        }

        List<List<Integer>> queenIndexes = new ArrayList<>();
        Set<Integer> busyCols = new HashSet<>();
        Set<Integer> busyFDiag = new HashSet<>();
        Set<Integer> busyBDiag = new HashSet<>();

        int row = 0;
        for (int col = 0; col < n; col++) {
            int fDiag = findFDiag(row, col);
            int bDiag = findBDiag(row, col, n - 1);
            busyCols.add(col);
            busyFDiag.add(fDiag);
            busyBDiag.add(bDiag);
            List<List<Integer>> solution = solveIt(1, n, busyCols, busyFDiag, busyBDiag);
            if (!solution.isEmpty()) {
                for (List<Integer> aSolution : solution) {
                    aSolution.add(col);
                }
            }
            queenIndexes.addAll(solution);
            busyCols.remove(col);
            busyFDiag.remove(fDiag);
            busyBDiag.remove(bDiag);
        }

        List<List<String>> out = new ArrayList<>();
        for (int i = queenIndexes.size() - 1; i >= 0; i--) {
            List<Integer> queenIndex = queenIndexes.get(i);
            List<String> item = new ArrayList<>();
            for (int j = queenIndex.size() - 1; j >= 0; j--) {
                Integer qIndex = queenIndex.get(j);
                String template = String.join("", Collections.nCopies(n, "."));
                item.add(template.substring(0, qIndex) + "Q" + template.substring(qIndex + 1));
            }
            out.add(item);
        }

        return out;
    }

    private List<List<Integer>> solveIt(int row,
                                  int n,
                                  Set<Integer> busyCols,
                                  Set<Integer> busyFDiag,
                                  Set<Integer> busyBDiag) {

        if (row == n - 1) {
            List<List<Integer>> solution = new ArrayList<>();
            for (int col = 0; col < n; col++) {
                int fDiag = findFDiag(row, col);
                int bDiag = findBDiag(row, col, n - 1);
                if (!busyCols.contains(col) && !busyFDiag.contains(fDiag) && !busyBDiag.contains(bDiag)) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(col);
                    solution.add(tmp);
                }
            }
            return solution;
        }

        List<List<Integer>> solutions = new ArrayList<>();
        for (int col = 0; col < n; col++) {
            int fDiag = findFDiag(row, col);
            int bDiag = findBDiag(row, col, n - 1);
            if (!busyCols.contains(col) && !busyFDiag.contains(fDiag) && !busyBDiag.contains(bDiag)) {
                busyCols.add(col);
                busyFDiag.add(fDiag);
                busyBDiag.add(bDiag);

                List<List<Integer>> solution = solveIt(row + 1, n, busyCols, busyFDiag, busyBDiag);

                busyCols.remove(col);
                busyFDiag.remove(fDiag);
                busyBDiag.remove(bDiag);
                if (!solution.isEmpty()) {
                    for (List<Integer> aSolution : solution) {
                        aSolution.add(col);
                    }
                }
                solutions.addAll(solution);
            }
        }

        return solutions;
    }

    private int findBDiag(int row, int col, int n) {
        int bottomRow = n - row;
        return bottomRow == col ? 0 : col > bottomRow ? col - bottomRow : - (bottomRow - col);
    }

    private int findFDiag(int row, int col) {
        return row == col ? 0 : row > col ? -(row - col) : col - row;
    }

    public static void main(String[] args) {
        Soution51 soution = new Soution51();
        System.out.println(soution.solveNQueens(4));
    }

}
