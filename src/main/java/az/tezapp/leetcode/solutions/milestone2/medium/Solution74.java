package az.tezapp.leetcode.solutions.milestone2.medium;

public class Solution74 {

    // ACCEPTED - 92%
    @SuppressWarnings("Duplicates")
    public boolean searchMatrixOptimized2(int[][] matrix, int target) {
        int rowCount = matrix.length;
        if (rowCount == 0) {
            return false;
        }
        int colCount = matrix[0].length;
        if (colCount == 0) {
            return false;
        }
        int from = 0;
        int to = rowCount * colCount - 1;
        while (to - from > 1) {
            int middle = (from + to) / 2;
            int row = middle / colCount;
            int col = middle % colCount;
            if (target <= matrix[row][col]) {
                to = middle;
            } else {
                from = middle;
            }
        }

        return isEqual(matrix, target, from, colCount) || isEqual(matrix, target, to, colCount);
    }

    private boolean isEqual(int[][] matrix, int target, int index, int colCount) {
        int row = index / colCount;
        int col = index % colCount;
        return matrix[row][col] == target;
    }

    // ACCEPTED - 3%
    @SuppressWarnings("Duplicates")
    public boolean searchMatrixOptimized(int[][] matrix, int target) {
        int rowCount = matrix.length;
        if (rowCount == 0) {
            return false;
        }
        int colCount = matrix[0].length;
        if (colCount == 0) {
            return false;
        }
        int len = rowCount * colCount;
        return binarySearchMatrix(matrix, target, 0, len - 1, colCount);
    }

    private boolean binarySearchMatrix(int[][] matrix, int target, int from, int to, int colCount) {
        if (from == to) {
            int row = from / colCount;
            int col = from % colCount;
            return matrix[row][col] == target;
        }
        int middle = (from + to) / 2;
        int row = middle / colCount;
        int col = middle % colCount;
        if (target <= matrix[row][col]) {
            return binarySearchMatrix(matrix, target, from, middle, colCount);
        } else {
            return binarySearchMatrix(matrix, target, middle + 1, to, colCount);
        }
    }

    // ACCEPTED - 7%
    public boolean searchMatrixOriginal(int[][] matrix, int target) {
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
