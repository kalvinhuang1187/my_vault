/*
121. Best Time to Buy and Sell Stock
---
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
---
Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0
 */

public class BuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // discovered a new absolute min
            if (prices[i] < min)
                min = prices[i];
            // recalculate the largest profit margin 
            else if (prices[i] > min)
                max = Math.max(prices[i] - min, max);
        }
        return max;
    }
}

