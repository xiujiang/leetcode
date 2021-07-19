package com.sf;

import java.util.ArrayList;
import java.util.List;

public class FourtySix {

    static List<List<Integer>> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        a.clear();
        b.clear();
        backTracking(nums,new ArrayList<>());
        return a;
    }
    public static void backTracking(int[] nums,List<Integer> used){
        if(b.size() == nums.length){
            a.add(new ArrayList<>(b));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used.contains(nums[i])){
                continue;
            }
            used.add(nums[i]);
            b.add(nums[i]);
            backTracking(nums,used);
            used.remove(used.size()-1);
            b.remove(b.size()-1);
        }
    }
}
