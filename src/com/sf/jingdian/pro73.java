package com.sf.jingdian;

public class pro73 {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        print(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        int[] r = new int[matrix.length];
        int[] c = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0) {
                    r[i] = 1;
                    c[j] = 1;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(c[j] == 1 || r[i] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void print(int[][] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j++){
                System.out.print(nums[i][j] +"  ");
            }
            System.out.println();
        }

    }

}
