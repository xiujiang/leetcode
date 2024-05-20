package com.sf.jingdian;

public class pro289 {
    public static void main(String[] args) {
        int[][] a = {{1,1},{1,0}};
        System.out.println(gameOfLife(a));
        print(a);
    }

    public static int[][] gameOfLife(int[][] board) {
        int[][] tmp = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                tmp[i][j] = board[i][j];
            }
        }
        int[] tmpIndex = {-1,0,1};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int cur = board[i][j];
                int total = 0;
                for(int k = 0; k < 3; k++){
                    for(int t = 0; t < 3; t++){
                        if(!(tmpIndex[k] == 0 && tmpIndex[t] == 0)){
                            int a = i + tmpIndex[k];
                            int b = j + tmpIndex[t];
                            if((a < board.length && a >= 0) && (b < board[0].length && b >= 0) && board[a][b] == 1){
                                total++;
                            }
                        }
                    }
                }
                if((total < 2 || total > 3) && cur == 1){
                    tmp[i][j] = 0;
                }else if(total == 3 && cur == 0){
                    tmp[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                board[i][j] = tmp[i][j];
            }
        }
        return board;
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
