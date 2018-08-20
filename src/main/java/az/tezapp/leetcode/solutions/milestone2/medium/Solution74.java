package az.tezapp.leetcode.solutions.milestone2.medium;

public class Solution74 {

    // ACCEPTED - 7% [todo: optimize]
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowIndex = searchRow(matrix, target, 0, matrix.length - 1);
        return binarySearch(matrix[rowIndex], target, 0, matrix[rowIndex].length - 1);
    }

    private boolean binarySearch(int[] data, int target, int from, int to) {
        if (from == to) {
            return data[from] == target;
        }
        int middle = (from + to) / 2;
        if (target > data[middle]) {
            return binarySearch(data, target, middle + 1, to);
        } else {
            return binarySearch(data, target, from, middle);
        }
    }

    private int searchRow(int[][] matrix, int target, int from, int to) {
        if (from == to) {
            return matrix[from][0] <= target ? from : from > 0 ? from - 1 : 0;
        }
        int middle = (from + to) / 2;
        if (target > matrix[middle][0]) {
            return searchRow(matrix, target, middle + 1, to);
        } else {
            return searchRow(matrix, target, from, middle);
        }
    }

}
