package com.sf.jingdian;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class pro169 {
    public static void main(String[] args) {
        int[] num = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(num));

    }
    public static int majorityElement(int[] nums) {
        int k = 0;
        int c = nums[0];
        int v = 0;
        for(int i = 0; i < nums.length; i++){
            if (v == 0) {
                c = nums[i];
            }
            v += c == nums[i] ? 1 : -1;
        }
        return c;
    }
}
