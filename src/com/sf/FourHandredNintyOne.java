package com.sf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FourHandredNintyOne {

    static List<List<Integer>> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        a.clear();
        b.clear();
        backTracking(0,nums);
        return a;
    }
    public static void backTracking(int index,int[] nums){
        if(b.size() >= 2){
            a.add(new ArrayList<>(b));
        }
        if(index > nums.length){
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = index; i < nums.length; i++){
            if( !b.isEmpty() && nums[i] < b.get(b.size()-1)
            || set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            b.add(nums[i]);
            backTracking(i+1,nums);
            b.remove(b.size()-1);
        }
    }
}
