package com.sf.jingdian;

public class pro122 {
    public static void main(String[] args) {
        int [] price = {7,1,5,3,6,4};
        System.out.println(maxProfit(price));
    }


    public static int maxProfit(int[] prices) {
        int cost = prices[0];
        int profit = 0;
        int total = 0;

        for(int i = 1; i < prices.length; i++){
            cost = Math.min(cost,prices[i]);
            int tmpProfit = prices[i] - cost;
            if(tmpProfit > 0){
                total += tmpProfit;
                cost = prices[i];
            }
        }

        return total;
    }



}
