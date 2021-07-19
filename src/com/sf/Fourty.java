package com.sf;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Fourty {
    static List<List<Integer>> a = new ArrayList<>();
    static List<Integer> t = new ArrayList<>();
    static int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        t.clear();
        a.clear();
        sum = 0;
        Arrays.sort(candidates);
        backTracking(0,target,candidates);
        return a;
    }

    public void backTracking(int index,int target,int[] candidates){
        if(sum > target){
            return;
        }
        if(sum == target){
            a.add(new ArrayList<>(t));
            return;
        }
        for(int i = index; i< candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            sum += candidates[i];
            t.add(candidates[i]);
            backTracking(i+1,target,candidates);
            sum -= candidates[i];
            t.remove(t.size()-1);
            String s = "";
            s.substring(0,s.length()-1);
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(s.substring(0,2));
        System.out.println(s.substring(1,2));
        System.out.println(s.substring(2,2));
        System.out.println(s.substring(3,2));
    }
    public static boolean isPart(String s,int l,int r){
        for(int i = l,j = r; i < j; i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
