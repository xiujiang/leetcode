package com.sf.jingdian;


public class pro121 {

    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxPrice = prices[0];
        int profit = 0;
        int total = 0;
        for(int i = 0; i < prices.length; i++){
            minPrice = Math.min(minPrice,prices[i]);
            int tmpProfit = prices[i] - minPrice;
            profit = profit > tmpProfit ? profit : tmpProfit;
        }
        return profit;
    }
}
