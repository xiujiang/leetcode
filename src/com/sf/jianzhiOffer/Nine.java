package com.sf.jianzhiOffer;

/**
 * 斐波那锲 数列
 * 1 1 2 3 5 8
 */
public class Nine {
    public static void main(String[] args) {
        System.out.println(fibo2(6));
    }
    private static int fibo(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return fibo(n-1)+fibo(n-2);
    }

    private static int fibo2(int n){
        if(n <= 2){
            return n;
        }
        int k = 1;
        int j = 1;
        int res = 0;
        for(int i = 3; i <= n; i++){
            res = k+j;
            k = j;
            j = res;
        }
        return res;
    }

    /**
     * 青蛙跳台阶
     * @param n
     * @return
     */
    private static int jumpFloor(int n){
        if(n < 3){
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int res = 0;
        for(int i = 3; i <= n; i++){
            res = f1+f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }

    /**
     * 正方形矩阵覆盖
     * @param n
     * @return
     */
    private static int fibo3(int n){
        int num = 1;
        int sum = 1;
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        while(n-- >= 2){
            sum += num;
            num = sum - num;
        }
        return sum;
    }

}
