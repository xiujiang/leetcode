package com.sf;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组(子数组最少包含一个元素)，返回其最 大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class FiftyThree {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = i; j < nums.length; j++){
                count+=nums[j];
                res = count>res?count:res;
            }
        }
        return res;
    }

    //贪心
    public int maxSubArray1(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
}
