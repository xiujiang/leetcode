package com.sf.jianzhiOffer;

/**
 * n 个骰子的点数及出现的概率
 * dp[0][0] =
 */
public class FourtyThree {

    public static void main(String[] args) {

    }

    public static void find(int n){
        int[][] dp = new int[n+1][6*n+1];
        int[] res = new int[5*n+1];
        for(int i = 2; i <= n; ++i){
            for(int sum = 6*i; sum >=i; --sum){

            }
        }
    }
}
