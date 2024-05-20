package com.sf.jingdian;

public class pro392 {
    public static void main(String[] args) {
        String s1 = "ax";
        String s2 = "ahbgdc";
        System.out.println(isSubsequence(s1,s2));
    }

    public static boolean isSubsequence(String s, String t) {
        int a = 0;
        int b = 0;
        while(a < s.length()){
            char c = s.charAt(a);
            while(b < t.length()){
                if(c == t.charAt(b)){
                    a++;
                    b++;
                    break;
                }
                b++;
            }
            if(a == s.length()){
                return true;
            }else if(b >= t.length()){
                return false;
            }
        }
        return true;
    }
}
