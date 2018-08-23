package az.tezapp.leetcode.solutions.milestone2.medium;

public class Solution75 {

    // ACCEPTED - 100%
    public void sortColors(int[] nums) {

        int[] pointers = new int[] {-1, -1, -1};
        for (int i = 0; i < nums.length; i++) {
            int prevValue = i == 0 ? 3 : nums[i - 1];
            int tmp = nums[i];
            if (prevValue > tmp) {
                if (pointers[tmp] == -1) {
                    int point = -1;
                    for (int j = 0; j < tmp; j++) {
                        if (pointers[j] > point) {
                            point = pointers[j];
                        }
                    }
                    point++;
                    pointers[tmp] = point;
                    if (point != i) {
                        nums[point] = tmp;
                        for (int j = tmp + 1; j < pointers.length; j++) {
                            if (pointers[j] != -1) {
                                pointers[j]++;
                                nums[pointers[j]] = j;
                            }
                        }
                    }
                } else {
                    for (int j = tmp; j < pointers.length; j++) {
                        if (pointers[j] != -1) {
                            pointers[j]++;
                            nums[pointers[j]] = j;
                        }
                    }
                }
            } else {
                pointers[tmp] = i;
            }
        }

    }

}
