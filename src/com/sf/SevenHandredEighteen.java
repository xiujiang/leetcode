package com.sf;

/**
 * 题目链接:https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/ 给两个整数数组 A 和 B ，返回两个数组中公共的、⻓度最⻓的子数组的⻓度。
 * 示例:
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出:3
 * 解释:
 * ⻓度最⻓的公共子数组是 [3, 2, 1] 。
 * 提示:
 * 1 <= len(A), len(B) <= 1000 0 <= A[i], B[i] < 100
 *
 * 1. 确定dp数组(dp table)以及下标的含义
 * dp[i][j] :以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最⻓重复子数组⻓度为dp[i][j]。
 * 此时细心的同学应该发现，那dp[0][0]是什么含义呢?总不能是以下标-1为结尾的A数组吧。
 * 其实dp[i][j]的定义也就决定着，我们在遍历dp[i][j]的时候i 和 j都要从1开始。
 * 那有同学问了，我就定义dp[i][j]为 以下标i为结尾的A，和以下标j 为结尾的B，最⻓重复子数组⻓度。不 行么?
 * 行倒是行! 但实现起来就麻烦一点，大家看下面的dp数组状态图就明白了。
 * 2. 确定递推公式
 * 根据dp[i][j]的定义，dp[i][j]的状态只能由dp[i - 1][j - 1]推导出来。 即当A[i - 1] 和B[j - 1]相等的时候，dp[i][j] = dp[i - 1][j - 1] + 1; 根据递推公式可以看出，遍历i 和 j 要从1开始!
 * 3. dp数组如何初始化
 * 根据dp[i][j]的定义，dp[i][0] 和dp[0][j]其实都是没有意义的!
 * 但dp[i][0] 和dp[0][j]要初始值，因为 为了方便递归公式dp[i][j] = dp[i - 1][j - 1] + 1;
 * 所以dp[i][0] 和dp[0][j]初始化为0。
 * 举个例子A[0]如果和B[0]相同的话，dp[1][1] = dp[0][0] + 1，只有dp[0][0]初始为0，正好符合递推公式 逐步累加起来。
 * 4. 确定遍历顺序 外层for循环遍历A，内层for循环遍历B。
 *
 * 那又有同学问了，外层for循环遍历B，内层for循环遍历A。不行么? 也行，一样的，我这里就用外层for循环遍历A，内层for循环遍历B了。 同时题目要求⻓度最⻓的子数组的⻓度。所以在遍历的时候顺便把dp[i][j]的最大值记录下来。
 * //TODO 未提交
 */
public class SevenHandredEighteen {
    public static void main(String[] args) {
        int[] x = new int[]{1,2,3,2,1};
        int[] y = new int[]{3,2,3,4,7};
        System.out.println(findLength1(x,y));
    }

    /**
     * 贪心
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A,int[] B){
        if(A.length == 0 || B.length == 0){
            return 0;
        }
        int length = Math.min(A.length,B.length);
        int c = 0;

        int res = 0;
        while(c < A.length){
            int count = 0;
            int i = c;
            for(int k = 0; k < B.length; k++){
                if(i < A.length && B[k] == A[i]){
                    count++;
                    i++;
                }else{
                    res = res>count?res:count;
                    i = c;
                }
            }
            c++;
        }
        return res;
    }

    /**
     * 动态规划
     * @param A
     * @param B
     * @return
     */
    public static int findLength1(int[] A,int[] B){
        int[][] dp = new int[A.length+1][B.length+1];
        //每个dp[i][j] 都由上一个dp[i-1][j-1] 推导出，推导公式是：dp[i][j] = dp[i-1][j-1]+1
        int res = 0;
        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= B.length; j++){
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                if(dp[i][j] > res){
                    res = dp[i][j];
                }
            }
        }
        return res;
    }
}
