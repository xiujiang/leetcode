package com.sf;

import java.util.ArrayList;
import java.util.List;

public class FourtySeven {
    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        permuteUnique(nums);
        System.out.println(a);
    }
    static List<List<Integer>> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();
    public static List<List<Integer>> permuteUnique(int[] nums){
        a.clear();
        b.clear();
        backTracking(nums,new boolean[nums.length]);
        return a;
    }

    public static void backTracking(int[] nums,boolean[] used){
        if(b.size() == nums.length){
            a.add(new ArrayList<>(b));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            if (used[i] == false) {
                used[i] = true;
                b.add(nums[i]);
                backTracking(nums,used);
                used[i] = false;
                b.remove(b.size()-1);

            }
        }
    }


}
