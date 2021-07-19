package com.sf;

/**
 * 题目链接:https://leetcode-cn.com/problems/is-subsequence/ 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些(也可以不删除)字符而不改变剩余字符相对位置形成的新 字符串。(例如，"ace"是"abcde"的一个子序列，而"aec"不是)。
 * 示例 1:
 * 输入:s = "abc", t = "ahbgdc" 输出:true
 * 示例 2:
 * 输入:s = "axc", t = "ahbgdc" 输出:false
 * 提示:
 * 0 <= s.length <= 100 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 *
 * //TODO
 */
public class ThreeHandredNintyFive {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abcd","ahbgdc"));
    }

    public static boolean isSubsequence(String s,String t){
        boolean flag;
        int x = 0;
        int k = 0;
        while(x < t.length()){
            if(s.charAt(k) == t.charAt(x)){
                k++;
            }
            if(k == s.length()){
                break;
            }
            x++;
        }
        return k==s.length()?true:false;

    }
}
