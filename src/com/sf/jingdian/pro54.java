package com.sf.jingdian;

import java.util.ArrayList;
import java.util.List;

public class pro54 {
    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] b = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] c = {{1}};
        int[][] d = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        System.out.println(spiralOrder1(d));
    }


    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int c = matrix[0].length;
        int r = matrix.length;
        if (c == 1 || r == 1) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++){
                    list.add(matrix[i][j]);
                }
            }
            return list;
        }
        int total = c * r;
        int k = 0;
        int startX = 0;
        int startY = 0;
        int offset = 1;
        int i,j;
        while(k < total){
            for(j = startY; j < c - offset; j++){
                list.add(matrix[startX][j]);
                k++;
            }
            for(i = startX; i < r - offset; i++){
                list.add(matrix[i][j]);
                k++;
            }
            for(;j > startY && list.size() < total;j--){
                list.add(matrix[i][j]);
                k++;
            }
            for(; i > startX && list.size() < total; i--){
                list.add(matrix[i][j]);
                k++;
            }
            startX++;
            startY++;
            offset++;
            if(k == (total - 1)){
                System.out.println(i+ "" + j);
                list.add(matrix[startX][startY]);
                k++;
            }
        }
        return list;
    }
}
