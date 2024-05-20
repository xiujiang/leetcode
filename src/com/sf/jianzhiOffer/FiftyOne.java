package com.sf.jianzhiOffer;

/**
 * 找出重复的数
 */
public class FiftyOne {
    public static void main(String[] args) {
        int[] x = new int[]{2,3,1,6,4,5,2,3};
        System.out.println(findNum(x));
    }
    public static int findNum(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; ++i){
            int next = nums[i] - 1;
            if (nums[i] > n) {
                next -= n;
            }
            if (nums[next] > n) {
                return next + 1;
            } else {
                nums[next] += n;
            }
        }
        return -1;
    }

    public static int findT(int[] x){
        int n = x.length;
        for (int i = 0; i < n; i++){
            int next = x[i]-1;
            if(x[i] > n){
                next -=n;
            }
            if(x[next] > n){
                return next+1;
            }else{
                x[next] +=n;
            }
        }
        return -1;
    }
}
