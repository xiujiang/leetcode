package com.sf;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢? 注意:给定 n 是一个正整数。
 * 示例 1:
 * 输入: 2
 * 输出: 2
 * 解释: 有两种方法可以爬到楼顶。
 * 1. 1阶+1阶 2. 2阶
 * 示例 2:
 * 输入: 3
 * 输出: 3
 * 解释: 有三种方法可以爬到楼顶。
 * 1. 1阶+1阶+1阶 2. 1阶+2阶
 * 3. 2阶+1阶
 */
public class Seventy1 {
    public static void main(String[] args) {
        System.out.println( climbStairs(5));;
    }

    public static int climbStairs(int n){
        if(n <=1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1]= 1;
        dp[2] = 2;
        int sum = 0;
        for(int i = 3; i <=n; i++){
            sum = dp[2]+dp[1];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }
}
