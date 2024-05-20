package com.sf.jingdian;

import java.util.HashMap;
import java.util.Map;

public class pro13 {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));

    }
    public static int romanToInt(String s) {
        Map<String,Integer> maps = new HashMap<>();
        maps.put("I",1);
        maps.put("V",5);
        maps.put("X",10);
        maps.put("L",50);
        maps.put("C",100);
        maps.put("D",500);
        maps.put("M",1000);
        maps.put("IV",4);
        maps.put("IX",9);
        maps.put("XL",40);
        maps.put("XC",90);
        maps.put("CD",400);
        maps.put("CM",900);
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            if(i < s.length() - 1){
                char c = s.charAt(i);
                if(c == 'I' || c == 'X' || c == 'C'){
                    char c1 = s.charAt(i+1);
                    if(maps.containsKey(String.valueOf(c)+ String.valueOf(c1))){
                        num += maps.get(String.valueOf(c)+ String.valueOf(c1));
                        i++;
                    }else{
                        num += maps.get(String.valueOf(c));
                    }
                }else{
                    num += maps.get(String.valueOf(c));
                }
            }else{
                num += maps.get(String.valueOf(s.charAt(i)));
            }
        }
        return num;
    }
}
