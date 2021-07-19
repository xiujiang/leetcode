package com.sf;

import java.util.ArrayList;
import java.util.List;

/**
 * 39
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Thirtynine {

    static List<List<Integer>> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();
    static int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        a.clear();
        b.clear();
        sum = 0;
        backTracking(0,target,candidates);
        return a;
    }
    public void backTracking(int index,int target,int[] candidates){
        if(sum > target){
            return;
        }
        if(sum == target){
            a.add(new ArrayList<>(b));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            sum+=candidates[i];
            b.add(candidates[i]);
            backTracking(i,target,candidates);
            sum-=candidates[i];
            b.remove(b.size()-1);
        }
    }

}
