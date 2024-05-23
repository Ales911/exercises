package com.example.exercises.leetcode;

public class MaxProfit121 {

    public int maxProfit(int[] prices) {
        int result = 0;
        int indexMin = 0;

//    Let's consider an example of [4,1,5,2,7]
//    4 is the cheapest price we see to start, and we can't sell on the first day so maxProfit is 0
//    1 is now the cheapest price we've seen. Selling now would lose us money, so we can't update maxProfit
//    5 is not cheaper than 1, but if we sell now we get a maxProfit of 4! Better save that for later
//    2 is not cheaper than 1 and if we sell, we only get a profit of 1, no need to do anything here
//    7 is not cheaper than 1, but if we sell here, we'll increase maxProfit to 6, making this the best profit to return.
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[indexMin]) {
                indexMin = i;
            } else {
                int dif = prices[i] - prices[indexMin];
                if (dif > result) {
                    result = dif;
                }
            }
        }
        return result;
    }

    void start() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        //int[] prices = {7, 6, 4, 3, 1};
        System.err.println(maxProfit(prices));
    }

    public static void main(String[] args) {
        new MaxProfit121().start();
    }

}
