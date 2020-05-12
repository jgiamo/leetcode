package main.java;


import java.util.PriorityQueue;

/**
 * 买卖股票的最佳时机，允许多次买卖，求最大值
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int sum = 0;
        int minValue = prices[0];
        int maxValue = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxValue) {
                maxValue = prices[i];
            } else {
                sum = sum + (maxValue - minValue);
                minValue = prices[i];
                maxValue = prices[i];
            }
        }
        sum = sum + (maxValue - minValue);
        return sum;
    }


    public static void main(String[] args) {

        BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new BestTimeToBuyAndSellStockII();

        System.out.println(
            bestTimeToBuyAndSellStockII.maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));

        System.out.println("hello world");
    }

}
