package com.sf.jingdian;

public class pro48 {
    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] b = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(a);
        System.out.println("aaa");
        print(a);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int loop = 0;

        /**
         * 00 01 02 03
         * 10 11 12 13
         * 20 21 22 23
         * 30 31 32 33
         */
        while(loop < n /2){
            int i = loop;
            int j = loop;
            int end = n - 1 - loop * 2;
            for(int t = 0; t < end; t++){
                int tmp = matrix[i + t][j + end];
                int a = matrix[i][j + t];
                int b = matrix[i + t][j + end];
                int c = matrix[i + end][j + end - t];
                int d = matrix[i + end - t][j];
                matrix[i + t][j + end] = matrix[i][j + t];
                matrix[i][j + t] = matrix[i + end - t][j];
                matrix[i + end - t][j] = matrix[i + end][j + end - t];
                matrix[i + end][j + end - t] = tmp;
                print(matrix);
                System.out.println();
            }
            loop++;
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
