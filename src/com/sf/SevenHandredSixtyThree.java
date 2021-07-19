package com.sf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 题目链接: https://leetcode-cn.com/problems/partition-labels/
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一
 * 个表示每个字符串片段的⻓度的列表。
 * 示例:
 * 输入:S = "ababcbacadefegdehijhklij"
 * 输出:[9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 提示:
 * S的⻓度在[1, 500]之间。 S只包含小写字母 'a' 到 'z' 。
 */
public class SevenHandredSixtyThree {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
    public static List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> maps = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            maps.put(s.charAt(i),i);
        }
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            max = maps.get(s.charAt(i))>max?maps.get(s.charAt(i)):max;
            if(max == i){
                res.add(max-sum+1);
                sum = max+1;
            }
        }
        return res;
    }


}
