package com.sf;

/**
 * 题目链接:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/ 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计 算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 示例 1:
 * 输入:[7,1,5,3,6,4]
 * 输出:5
 * 解释:在第 2 天(股票价格 = 1)的时候买入，在第 5 天(股票价格 = 6)的时候卖出，最大利润 = 6-1 = 5 。注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格;同时，你不能在买入前卖出股票。
 * 示例 2:
 * 输入:prices = [7,6,4,3,1]
 * 输出:0
 * 解释:在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class OneHandredTwentyOne {
    public static void main(String[] args) {
        int[] x = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit1(x));
    }
    public static int maxProfit(int[] nums){
        int res = 0;
        int nu1 = nums[0];
        for(int i = 1; i < nums.length; i++){
            nu1 = Math.min(nu1,nums[i]);
            res = Math.max(res,nums[i] - nu1);
        }
        return res;
    }

    public static int maxProfit1(int[] nums){
        int[][] dp = new int[nums.length][2];
        //dp[i][0] = Math.max(dp[i-1][0],-price[i])
        //dp[i][1] = Math.max(dp[i-1][1],price[i]+dp[i][0])
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = Math.min(dp[i-1][0],nums[i]);
            dp[i][1] = Math.max(dp[i-1][1],nums[i]-dp[i-1][0]);
        }
        return dp[nums.length-1][1];
    }
}
