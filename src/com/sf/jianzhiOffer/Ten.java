package com.sf.jianzhiOffer;

public class Ten {
    public static void main(String[] args) {

    }

    /**
     * 1111
     * 1110
     * 1110
     * 1101
     *
     *
     * @param n
     * @return
     */
    private static int number(int n){
        int count = 0;
        while (n != 0) {
            count++;
            n = (n-1)&n;
        }
        return count;
    }
}
