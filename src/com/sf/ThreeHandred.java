package com.sf;

/**
 * 题目链接:https://leetcode-cn.com/problems/longest-increasing-subsequence/ 给你一个整数数组 nums ，找到其中最⻓严格递增子序列的⻓度。
 * 子序列是由数组派生而来的序列，删除(或不删除)数组中的元素而不改变其余元素的顺序。例如， [3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 示例 1:
 * 输入:nums = [10,9,2,5,3,7,101,18]
 * 输出:4
 * 解释:最⻓递增子序列是 [2,3,7,101]，因此⻓度为 4 。
 * 示例 2:
 * 输入:nums = [0,1,0,3,2,3] 输出:4
 * 示例 3:
 * 输入:nums = [7,7,7,7,7,7,7] 输出:1
 *
 * 提示:
 * 1 <= nums.length <= 2500 -10^4 <= nums[i] <= 104
 * 明确题目中的条件：
 *
 * 子序列：不要求连续子序列，只要保证元素前后顺序一致即可；
 * 上升：这里的「上升」是「严格上升」，例如： [2, 3, 3, 6, 7] 这样的子序列是不符合要求的。
 * 题目只问最长上升子序列的长度，没有问最长上升子序列是什么，因此考虑使用动态规划。
 *
 * 第 1 步：状态定义。dp[i] 表示以 nums[i] 结尾的最长上升子序列的长度。即：在 [0, ..., i] 的范围内，选择以数字 nums[i] 结尾可以获得的最长上升子序列的长度。
 *
 * 说明：以 nums[i] 结尾，是子序列动态规划问题的经典设计状态思路，思想是动态规划的无后效性（定义得越具体，状态转移方程越好推导）。
 *
 * 第 2 步：推导状态转移方程：遍历到 nums[i] 的时候，我们应该把下标区间 [0, ... ,i - 1] 的 dp 值都看一遍，如果当前的数 nums[i] 大于之前的某个数，那么 nums[i] 就可以接在这个数后面形成一个更长的上升子序列。把前面的数都看了， dp[i] 就是它们的最大值加 $1$。即比当前数要小的那些里头，找最大的，然后加 $1$ 。
 *
 * 状态转移方程即：dp[i] = max(1 + dp[j] if j < i and nums[j] < nums[i])。
 *
 * 第 3 步：初始化。单独一个数是子序列，初始化的值为 1；
 *
 * 第 4 步：输出。应该扫描这个 dp 数组，其中最大值的就是题目要求的最长上升子序列的长度。
 */
public class ThreeHandred {
    public static void main(String[] args) {
        int[] x = new int[]{0,1,0,3,2,3};
        // 0 0 0 1 1 2 3 0
        System.out.println(lengthOfLIS(x));
    }
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i] > res){
                res = dp[i];
            }
        }
        return res+1;
    }

}
