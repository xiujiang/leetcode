package com.sf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 题目链接:https://leetcode-cn.com/problems/merge-intervals/ 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 注意:输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * 提示:
 * intervals[i][0] <= intervals[i][1]
 * [[1,3],[2,6],[8,10],[15,18]]
 * 输出：
 * [[1,6],[8,10]]
 * 预期结果：
 * [[1,6],[8,10],[15,18]]
 */
public class FiftySix {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Arrays.sort(a,(o1, o2) -> o1[0] > o2[0]?1:o1[0]==o2[0]?o1[1]>o2[1]?-1:1:-1);
        for (int[] ints : a) {
            System.out.println(ints[0]+" "+ints[1]);
        }
        int[][] x = merge(a);
        System.out.println("xxx");
        for (int[] ints : x) {
            System.out.println(ints[0]+" "+ints[1]);
        }
    }
   public static int[][] merge(int[][] intervals) {
       int[][] x = new int[intervals.length][2];
       Arrays.sort(intervals,(o1, o2) -> o1[0] > o2[0]?1:o1[0]==o2[0]?o1[1]>o2[1]?-1:1:-1);
       int end = intervals[0][1];
       int start = intervals[0][0];
       int k = 0;
       for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(intervals[i][1],end);
            }else{
                x[k][0] = start;
                x[k][1] = end;
                start = intervals[i][0];
                end = intervals[i][1];
                k++;
            }
       }
       x[k][0] = start;
       x[k][1] = end;
       int[][] res = new int[k+1][2];
       for(int i = 0; i <= k; i++){
           res[i][0] = x[i][0];
           res[i][1] = x[i][1];
       }
       return res;
    }
}
