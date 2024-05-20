package com.sf.jingdian;

public class pro55 {
    public static void main(String[] args) {
        int[] nums = {5,4,0,2,0,1,0,1,0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int jumpStep = nums[0];
        boolean canJump = jumpStep > 0;
        boolean canfinish = nums.length == 1;
        for(int i = 0; i < nums.length; i++){
            if(canfinish){
                return true;
            }
            if(!canJump){
                return false;
            }
            canfinish = nums[i] + i >= nums.length-1;
            jumpStep--;
            jumpStep = Math.max(jumpStep,nums[i]);
            canJump = jumpStep > 0;
        }
        return false;
    }
}
