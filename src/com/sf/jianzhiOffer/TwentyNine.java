package com.sf.jianzhiOffer;

/**
 * 数组中出现次数超过一半的数字
 */
public class TwentyNine {

    public static void main(String[] args) {

    }
    public static boolean exist(int[] nums){
        int count = 0;
        int val = 0;
        for (int i = 0; i < nums.length; i++){
            if(count == 0){
                val = nums[i];
            }
            count += (val==nums[i])?1:-1;
        }
        int time = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                time++;
            }
        }
        return time*2 > nums.length?true:false;
    }
}
