package com.sf;

/**
 * 题目链接:https://leetcode-cn.com/problems/unique-paths/
 * 一个机器人位于一个 m x n 网格的左上⻆ (起始点在下图中标记为 “Start” )。 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下⻆(在下图中标记为 “Finish” )。 问总共有多少条不同的路径?
 *
 * 输入:m = 3, n = 7 输出:28
 * 示例 2:
 * 输入:m = 2, n = 3
 * 输出:3
 * 解释:
 * 从左上⻆开始，总共有 3 条路径可以到达右下⻆。
 * 1. 向右->向右->向下 2. 向右->向下->向右 3. 向下->向右->向右
 * 示例 3:
 * 输入:m = 7, n = 3 输出:28
 * 示例 4:
 * 输入:m = 3, n = 3 输出:6
 * 提示:
 * 1 <= m, n <= 100 题目数据保证答案小于等于 2 * 10^9
 */
public class SixtyTwo {

    public static void main(String[] args) {
        System.out.println(uniquePaths(2,3));
    }
    public static int uniquePaths(int m,int n){
        int[][] x = new int[m][n];
        for(int i = 0; i < m; i++){
            x[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            x[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                x[i][j] = x[i-1][j]+x[i][j-1];
            }
        }
        return x[m-1][n-1];
    }

}
