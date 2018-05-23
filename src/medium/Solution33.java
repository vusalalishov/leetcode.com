package medium;

public class Solution33 {

    public static void main(String[] args) {
        Solution33 solution = new Solution33();
        System.out.println(solution.search(new int[]{
                4, 5, 6, 7, 0, 1, 2, 3
        }, 4));
    }

    // 82%
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int from, int to) {
        int middle = (from + to) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (from == to || from > to) {
            return -1;
        } else if (nums[from] <= nums[middle] && nums[to] >= nums[middle]) {
            if (target > nums[middle]) {
                return binarySearch(nums, target, middle + 1, to);
            } else {
                return binarySearch(nums, target, from, middle - 1);
            }
        } else if (nums[to] < nums[middle]) {
            if (target < nums[middle] && target >= nums[from]) {
                return binarySearch(nums, target, from, middle - 1);
            } else {
                return binarySearch(nums, target, middle + 1, to);
            }
        } else if (nums[from] > nums[middle]) {
            if (target > nums[middle] && target <= nums[to]) {
                return binarySearch(nums, target, middle + 1, to);
            } else {
                return binarySearch(nums, target, from, middle - 1);
            }
        } else {
            return -1;
        }
    }

}
