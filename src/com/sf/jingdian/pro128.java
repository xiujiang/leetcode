package com.sf.jingdian;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class pro128 {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for(int num : nums){
            if(!set.contains(num-1)){
                int curLength = 1;
                int curNum = num;
                while(set.contains(curNum + 1)){
                    curLength++;
                    curNum += 1;
                }
                maxLength = Math.max(curLength,maxLength);
            }
        }
        return maxLength;
    }
}
