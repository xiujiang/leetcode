package com.sf;

/**
 * 题目链接:https://leetcode-cn.com/problems/unique-paths-ii/
 * 一个机器人位于一个 m x n 网格的左上⻆ (起始点在下图中标记为“Start” )。 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下⻆(在下图中标记为“Finish”)。 现在考虑网格中有障碍物。那么从左上⻆到右下⻆将会有多少条不同的路径?
 * 输入:obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] 输出:2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。 从左上⻆到右下⻆一共有 2 条不同的路径:
 * 1. 向右->向右->向下->向下 2. 向下->向下->向右->向右
 * 输入:obstacleGrid = [[0,1],[0,0]] 输出:1
 * 提示:
 * m == obstacleGrid.length n == obstacleGrid[i].length 1 <= m, n <= 100 obstacleGrid[i][j] 为 0 或 1
 */
public class SixtyThree {

    public static void main(String[] args) {
        int[][] a = new int[][]{{0,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(a));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        int[][] x = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < x.length; i++){
            if(obstacleGrid[i][0] != 0){
                break;
            }
            x[i][0] = 1;
        }
        for(int j = 0; j < x[0].length; j++){
            if(obstacleGrid[0][j] != 0){
                break;
            }
            x[0][j] = 1;
        }

        for(int i = 1; i < x.length; i++){
            for(int j = 1; j < x[0].length; j++){
                if(obstacleGrid[i][j] == 1){
                    continue;
                }
                x[i][j] = x[i][i-1]+x[i-1][j];
            }
        }
        return x[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
