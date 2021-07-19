package com.sf;

import java.util.ArrayList;
import java.util.List;

public class SeventyEight {
    static List<List<Integer>> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(0,nums);
        return a;
    }

    public static void backTracking(int index,int[] nums){
        a.add(new ArrayList<>(b));
        if(index > nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            b.add(nums[i]);
            backTracking(i+1,nums);
            b.remove(b.size()-1);
        }
    }

}
