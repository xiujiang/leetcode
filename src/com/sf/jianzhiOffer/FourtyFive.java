package com.sf.jianzhiOffer;

/**
 *  圆圈中最后剩下的数
 */
public class FourtyFive {

    public static void main(String[] args) {
        int i = lastRemain(4, 3);
        System.out.println(i);
    }

    /**
     * 1 2 3 4 5
     * @param n
     * @param m
     * @return
     */
    public static int lastRemain(int n,int m){
        if(n < 1 || m < 1){
            return -1;
        }
        if(n == 1){
            return 1;
        }
        int last = -1;
        for (int i = 2; i <= n; i++){
            last = (last+m)%i;
        }
        return last;
    }

}
