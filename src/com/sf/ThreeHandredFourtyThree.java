package com.sf;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的 最大乘积。
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class ThreeHandredFourtyThree {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n){
        int[] x = new int[n+1];
        x[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i-1; j++){
                x[i] = Math.max(Math.max((i-j)*j,x[i-j]*j),x[i]);
            }
        }
        return x[n];
    }
}
