package com.sf.jianzhiOffer;

import java.util.Arrays;

/**
 * 扑克牌的顺子
 */
public class FourtyFour {
    public static void main(String[] args) {

    }
    public static boolean adjust(int[] nums){
        if(nums == null || nums.length == 0){
            return false;
        }
        Arrays.sort(nums);
        int count = 0;
        for(int i = 1; i < nums.length-1; i++){
            count+= nums[i]-nums[i-1];
        }
        if(count != 5){
            return false;
        }else{
            return true;
        }
    }
}
