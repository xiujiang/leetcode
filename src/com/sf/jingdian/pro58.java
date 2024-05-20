package com.sf.jingdian;

import java.util.List;

public class pro58 {
    public static void main(String[] args) {
        String s = "aa bb cc  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int n = s.length()-1;
        s = s.trim();
        String[] strs = s.split(" ");
        return strs[strs.length-1].length();
    }


}
