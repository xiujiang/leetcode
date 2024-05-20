package com.sf.jingdian;

public class pro11 {
    public static void main(String[] args) {
        int[] height = {1,8,1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while(l < r){
            max = Math.max(Math.min(height[l],height[r]) * (r - l),max);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;

    }
}
