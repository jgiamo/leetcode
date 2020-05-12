package main.java;


/**
 * 买卖股票的最佳时机，允许最多两次交易，求最大值
 */
public class BestTimeToBuyAndSellStockIII {


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

        BestTimeToBuyAndSellStockIII bestTimeToBuyAndSellStockIII = new BestTimeToBuyAndSellStockIII();

        System.out.println(bestTimeToBuyAndSellStockIII.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

        System.out.println("hello world");
    }

}
