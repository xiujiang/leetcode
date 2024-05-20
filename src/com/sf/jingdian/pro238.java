package com.sf.jingdian;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 *
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 */
public class pro238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        productExceptSelf(nums);
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] val = new int[nums.length];
        int left = 1;
        int right = 1;
        for(int i = 0; i < nums.length; i++){
            val[i] = 1;
        }
        for(int i = 0; i < nums.length; i++){
            val[i] = val[i] * left;
            left = left * nums[i];
            val[nums.length-1 - i] = val[nums.length - 1 - i] * right;
            right = right * nums[nums.length - 1 - i];
        }
        return val;
    }

    static void print(int[] num){
        for(int i = 0; i < num.length; i++){
            System.out.print(num[i]+" ");
        }
    }
}
