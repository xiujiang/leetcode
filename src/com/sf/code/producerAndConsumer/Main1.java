package com.sf.code.producerAndConsumer;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
public class Main1 {
    static Integer count = 0;

    public static void main(String[] args) {

        while(true){
            System.out.println("a");
        }

    }

    public static void find(int[][] num,int i,int j){
        if(i >= num.length || i < 0 || j >= num.length || j < 0){
            return;
        }
        if(num[i][j] == 0){
            return;
        }

        num[i][j] = 0;
        find(num,i+1,j);
        find(num,i,j+1);
        find(num,i-1,j);
        find(num,i,j-1);

    }

    public static void findT(int[][] num){
        for(int i = 0; i < num.length; i++){
            for(int j = 0; j < num.length; j++){
                if(num[i][j] == 1){
                    count++;

                    find(num,i,j);
                    for(int a = 0; a < num.length; a++){
                        for(int b = 0; b < num.length; b++){
                            System.out.print(num[a][b]+"  ");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }

}