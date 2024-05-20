package com.sf.jianzhiOffer;

/**
 *
 */
public class Fourty {

    public static void main(String[] args) {
        int[] x = new int[]{1,1,2,3,4,4,5,5,2,3,6,7,7};
//        int one = findOne(x);
//        System.out.println(one);
        System.out.println(1^5);
    }

    public static int findOne(int[] nums){
        if(nums == null){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int num = nums[0];
        for (int i = 1; i < nums.length; i++){
            num ^= nums[i];
        }
        return num;
    }
}
