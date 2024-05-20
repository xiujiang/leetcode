package com.sf.jingdian;

public class pro28 {
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "leeto";
        System.out.println(strStr(s1,s2));
    }

    public static int strStr(String haystack, String needle) {
        int start = 0;
        int end = needle.length();
        for(int i = 0; i < haystack.length(); i++){
            char t = haystack.charAt(i);
            start = 0;
            if(t == needle.charAt(start)){
                if(haystack.length() - i < end){
                    return -1;
                }
                for(int j = i + 1; j < i + end; j++){
                    if(haystack.charAt(j) != needle.charAt(++start)){
                        start = 0;
                        break;
                    }
                }
                if(start+1 == end){
                    return i;
                }
            }
        }
        return -1;
    }
}
