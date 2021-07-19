package com.sf;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoHandredSisty {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3,7));
    }
    static List<List<Integer>> a = new ArrayList<>();
    static List<Integer> t = new ArrayList<>();
    static int sum = 0;
    public static List<List<Integer>> combinationSum3(int k, int n) {
        blackTracking(k,n,1);
        return a;
    }

    public static void blackTracking(int k, int n, int index){
        if(t.size() == k){
            if(n == sum){
                a.add(new ArrayList<>(t));
            }
            return;
        }
        if(sum >= n){
            return;
        }
        for(int i = index; i < 9-(k-t.size())+1; i++){
            t.add(i);
            sum+=i;
            blackTracking(k,n,i+1);
            t.remove(t.size()-1);
            sum-=i;
        }
    }
}
