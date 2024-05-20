package com.sf.jianzhiOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 滑动窗口的最大值
 */
public class Sixtyfive {

    public static void main(String[] args) {

    }

    public static int findMax(int[] nums,int size){
        List<Integer> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(r-l < size){
                r++;
                count += nums[i];
            }else if(r-l > size){
            }
        }
        return 0;
    }

}
