package com.sf.jingdian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pro12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }

    public static String intToRoman(int num) {
        Map<Integer,String> map = new HashMap<>();
        String str = "";
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i = 0; i < nums.length; i++){
            int c = num / nums[i] > 0 ? num / nums[i] : 0;
            if(c > 0){
                num = num % nums[i];
                for(int j = 0; j < c; j++){
                    str = str + getNumStr(nums[i]);
                }
            }
        }
        return str;
    }

    static String getNumStr(int num){
       switch (num){
           case 1000:
               return "M";
           case 900:
               return "CM";
           case 500:
               return "D";
           case 400:
               return "CD";
           case 100:
               return "C";
           case 90:
               return "XC";
           case 50:
               return "L";
           case 40:
               return "XL";
           case 10:
               return "X";
           case 9:
               return "IX";
           case 5:
               return "V";
           case 4:
               return "IV";
           case 1:
               return "I";

       }
       return "";
    }
}
