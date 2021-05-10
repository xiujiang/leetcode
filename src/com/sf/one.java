package com.sf;

public class one {
    public static void main(String[] args) {
//        Solution.twoSum();
    }
}

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int x,y;
        for(x = 0; x < nums.length; x++){
            for(y = x+1; y < nums.length; y++){
                if(nums[x] + nums[y] == target){
                    return new int[]{x,y};
                }
            }
        }
        return null;
    }
}
