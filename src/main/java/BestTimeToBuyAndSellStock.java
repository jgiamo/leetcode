package main.java;


/**
 * 买卖股票的最佳时机，只允许买卖一次
 */
public class BestTimeToBuyAndSellStock {


    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int largeMinusValue = 0;
        int minValue = prices[0];
        int maxValue = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > maxValue){
                maxValue = prices[i];
                largeMinusValue = Math.max(maxValue - minValue , largeMinusValue);
            }
            if(prices[i] < minValue){
                minValue = prices[i];
                maxValue = prices[i];
            }
        }

        return largeMinusValue;

    }

    public static void main(String[] args) {

        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

        System.out.println("hello world");
    }

}
