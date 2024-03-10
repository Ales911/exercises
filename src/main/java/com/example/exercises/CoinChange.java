package com.example.exercises;

public class CoinChange {

    // m is size of coins array (number of different coins)
    static int minCoins(int coins[], int m, int v) {
        // base case
        if (v == 0) {
            return 0;
        }

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than v
        for (int i = 0; i < m; i++) {
            if (coins[i] <= v) {
                int sub_res = minCoins(coins, m, v - coins[i]);

                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
                    res = sub_res + 1;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int v = 11;
        System.out.println("Minimum coins required is " + minCoins(coins, m, v));
    }
}
