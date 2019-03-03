package az.tezapp.leetcode.solutions.milestone3.hard;

public class Solution135 {

    // ACCEPTED - 100%
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];

        int candyCount = 0;

        candies[0] = 1;
        // check for inc
        for (int i = 1; i < ratings.length; i++) {
            candies[i] = ratings[i] > ratings[i - 1] ? candies[i - 1] + 1 : 1;
        }


        // check for dec
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (candies[i] == 1 && ratings[i] > ratings[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        for (int i = 1; i < ratings.length - 1; i++) {
            if (ratings[i] > ratings[i - 1] && ratings[i] > ratings[i + 1]) {
                while (candies[i] <= candies[i - 1] || candies[i] <= candies[i + 1]) {
                    candies[i]++;
                }
            }
            candyCount += candies[i];
        }

        candyCount += candies[0];
        if (candies.length > 1) {
            candyCount += candies[candies.length - 1];
        }

        return candyCount;
    }

    public static void main(String[] args) {
        Solution135 solution = new Solution135();
        System.out.println(solution.candy(new int[] {0}));
    }

}
