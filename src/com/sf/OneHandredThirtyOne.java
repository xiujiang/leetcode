package com.sf;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHandredThirtyOne {
    static List<List<String>> a = new ArrayList<>();
    static List<String> b = new ArrayList<>();
    public List<List<String>> partition(String s) {
        a.clear();
        b.clear();
        backTracking(0,s);
        return a;
    }

    public static void backTracking(int index,String s){
        if(index >= s.length()){
            a.add(new ArrayList(b));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPart(s,index,i)){
                b.add(s.substring(index,i+1));
            }else{
                continue;
            }
            backTracking(i+1,s);
            b.remove(b.size()-1);
        }
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
