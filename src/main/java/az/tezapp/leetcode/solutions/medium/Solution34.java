package az.tezapp.leetcode.solutions.medium;

import java.util.Arrays;

public class Solution34 {

    public static void main(String[] args) {
        Solution34 solution = new Solution34();
        int[] data = new int[] {
                5, 7, 7, 8, 8, 10
        };
        System.out.println(Arrays.toString(solution.searchRange(data, 6)));

    }

    // TODO: review discussion forum
    // 73% - ACCEPTED
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        boolean isExists = nums[0] <= target && nums[nums.length - 1] >= target;
        if (isExists) {
            int leftIndex = findIndex(nums, target, 0, nums.length - 1, true);
            int rightIndex = findIndex(nums, target, 0, nums.length - 1, false);
            return new int[] {leftIndex, rightIndex};
        } else {
            return new int[] {-1, -1};
        }
    }

    private int findIndex(int[] nums, int target, int l, int r, boolean isStartIndex) {
        int m = (l + r) / 2;
        if (r - l == 1) {
            if (nums[isStartIndex ? l : r] == target) {
                return isStartIndex ? l : r;
            } else {
                if (nums[isStartIndex ? r : l] == target) {
                    return isStartIndex ? r : l;
                } else {
                    return -1;
                }
            }
        } else if (l == r) {
            if (nums[l] == target) {
                return l;
            } else {
                return -1;
            }
        }

        if (nums[m] == target) {
            return findIndex(nums, target, isStartIndex ? l : m, isStartIndex ? m : r, isStartIndex);
        }

        if (nums[m] > target) {
            return findIndex(nums, target, l, m - 1, isStartIndex);
        } else {
            return findIndex(nums, target, m + 1, r, isStartIndex);
        }
    }

    private int startIndex(int[] nums, int target, int l, int r) {
        int m = (l + r) / 2;
        if (r - l == 1) {
            if (nums[l] == target) {
                return l;
            } else {
                if (nums[r] == target) {
                    return r;
                } else {
                    return -1;
                }
            }
        } else if (l == r) {
            if (nums[l] == target) {
                return l;
            }
            return -1;
        }
        if (nums[m] == target) {
            if (l < r) {
                return startIndex(nums, target, l, m);
            } else {
                return -2;
            }
        }
        if (nums[m] > target) {
            return startIndex(nums, target, l, m - 1);
        } else {
            return startIndex(nums, target, m + 1, r);
        }
    }

    private int endIndex(int[] nums, int target, int l, int r) {
        int m = (l + r) / 2;
        if (r - l == 1) {
            if (nums[r] == target) {
                return r;
            } else {
                if (nums[l] == target) {
                    return l;
                }
                return -1;
            }
        } else if (l == r) {
            if (nums[l] == target) {
                return l;
            } else {
                return -1;
            }
        }
        if (nums[m] == target) {
            if (l < r) {
                return endIndex(nums, target, m, r);
            } else {
                return -1;
            }
        }
        if (nums[m] > target) {
            return endIndex(nums, target, l, m - 1);
        } else {
            return endIndex(nums, target, m + 1, r);
        }
    }

}
