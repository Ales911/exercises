package com.example.exercises;

public class CoinChange2 {

    public static int coinChange(int[] coins, int amount) {
        // dp[i] will be storing min number of coins required for i value.
        // So dp[amount] will have result.
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // Base case (if given value amount is 0)
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int sub_res = dp[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < dp[i]) {
                        dp[i] = sub_res + 1;
                    }
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public static void main(String args[]) {
        int coins[] = {9, 6, 5, 1};
        int amount = 22;
        System.out.println("Minimum coins required is " + coinChange(coins, amount));
    }
}
