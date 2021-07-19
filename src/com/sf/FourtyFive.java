package com.sf;

/**
 * 题目地址:https://leetcode-cn.com/problems/jump-game-ii/ 给定一个非负整数数组，你最初位于数组的第一个位置。 数组中的每个元素代表你在该位置可以跳跃的最大⻓度。 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最 后一个位置。
 * 说明: 假设你总是可以到达数组的最后一个位置。
 */
public class FourtyFive {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4,3,1,1,5,2,1,3,6,7,1};
        System.out.println(jumps(nums));
    }
    public static int jump(int[] nums) {
        int res = 1;
        int currPos = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(max != 0){
                currPos += max;
            }else{
                currPos = nums[i];
            }
            if(currPos>=nums.length){
                return res;
            }else{
                for(int j = i+1; j <= currPos; j++){
                    max = nums[j] > max?nums[j]:max;

                }
            }
            res++;
        }
        return res;
    }

    public static int jumps(int[] nums) {
        if (nums.length == 1) return 0;
        int curDistance = 0;
        int ans = 0;
        int nextDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nums[i] + i, nextDistance);
            if (i == curDistance) {
                if (curDistance != nums.length - 1) {
                    ans++;
                    curDistance = nextDistance;
                    if (nextDistance >= nums.length - 1) break;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
