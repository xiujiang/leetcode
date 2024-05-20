package com.sf.jingdian;

import java.util.ArrayList;
import java.util.List;

public class pro228 {
    public static void main(String[] args) {

    }


    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0){
            return list;
        }
        int tmp = nums[0];
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            if(tmp == nums[i]){
                tmp++;
                continue;
            }
            if(start == i - 1){
                list.add(String.valueOf(nums[start]));
            }else{
                list.add(nums[start] + "->" + nums[i - 1]);
            }
            tmp = nums[i] + 1;
            start = i;
        }
        if(start == nums.length - 1){
            list.add(String.valueOf(nums[start]));
        }else{
            list.add(nums[start] + "->" + nums[nums.length - 1]);
        }
        return list;
    }
}
