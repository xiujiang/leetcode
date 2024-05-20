package com.sf.jingdian;

import com.sun.jmx.snmp.SnmpNull;

public class pro209 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLen(11,nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j;
        int sum = 0;
        int min = 0;
        for(j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum >= target){
                min = min == 0 ? (j - i + 1) : Math.min(min,(j - i + 1));
                sum -= nums[i++];
            }
        }
        return min;
    }
}
