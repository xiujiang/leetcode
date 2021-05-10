package com.sf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class seventySeven {
    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> a = new ArrayList<>();
        backTrack(1,k,n,new ArrayList<>(),a);
        return a;
    }

    public static void backTrack(int b,int k,int n,List<Integer> lt,List<List<Integer>> a){
        if(lt.size() == k){
            a.add(new ArrayList(lt));
            return;
        }
        for(int i = b; i <= n; i++){
            lt.add(i);
            backTrack(i+1,k,n,lt,a);
            lt.remove(lt.size()-1);
        }
    }
//    public static void dfs(int n,int k, int index){
//        if(lt.size() == k){
//            a.add(new ArrayList(lt));
//            return;
//        }
//        for (int i = index; i <= n; i++) {
//            lt.add(i);
//            dfs(n, k, i + 1); // 递归
//            lt.remove(lt.size()-1); // 回溯，撤销处理的节点
//        }
//    }
}
