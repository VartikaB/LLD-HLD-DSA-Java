package DSA.DP;

class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount + 1][n];
        for (int i = 0; i <= amount; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(amount, coins, 0, dp);
    }

    public int helper(int amount, int[] coins, int index, int[][] dp) {
        if (amount == 0)
            return 1;
        if (index >= coins.length || amount < 0)
            return 0;
        if (dp[amount][index] != -1)
            return dp[amount][index];
        int take = helper(
            amount - coins[index],
            coins,
            index,
            dp
        );
        int notTake = helper(
            amount,
            coins,
            index + 1,
            dp
        );

        return dp[amount][index] = take + notTake;
    }
}
