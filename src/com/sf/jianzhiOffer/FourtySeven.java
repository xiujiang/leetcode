package com.sf.jianzhiOffer;

/**
 * 不用加减乘除做加法
 */
public class FourtySeven {

    public static void main(String[] args) {
        int add = Add(10, 2);
        System.out.println(add);
    }

    /**
     * 1010
     * 0010
     *
     * 1000
     * 0010->0100
     *
     * 1000
     * 0100
     * 1100
     * 0000
     *
     *
     *
     * @param a
     * @param b
     * @return
     */
    public static int Add(int a,int b){
        while(b != 0){
            int temp = a ^ b;       //使各 bit 位相加，不计算进位
            b = (a & b) << 1;       //将发生进位的位置找到
            a = temp;
            System.out.println(a+" "+b);
        }
        return a;
    }
}
