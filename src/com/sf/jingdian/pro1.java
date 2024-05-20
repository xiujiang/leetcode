package com.sf.jingdian;

import java.util.Arrays;

public class pro1 {
    public int[] twoSum1(int[] nums, int target) {
        int[] t = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1 ; j < nums.length; j++){
                if(target == (nums[i] + nums[j])){
                    t[0] = i;
                    t[1] = j;
                    return t;
                }
            }
        }
        return t;
    }
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        return new int[]{1,2};
    }
}
