package com.sf.jianzhiOffer;

/**
 * 求1到n的和
 * 1 2 3 4 5
 */
public class FoutySix {

    public static void main(String[] args) {
        System.out.println(findSum(10));
    }

    public static int findSum(int n){
        if(n == 1){
            return 1;
        }
        return findSum(n-1)+n;
    }
}
