package com.sf;

public class twentyeight {
    public static void main(String[] args) {
        String s = "123";
        String haystack = "aaaaab";
        String needle = "bba";
        System.out.println(strStr(haystack,needle));
    }

    /**
     * 暴力
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr0(String haystack, String needle){
        if(needle.length() == 0){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        for(int i = 0; i < haystack.length(); i++){
            int k = i;
            for(int j = 0; j < needle.length(); j++){
                if(haystack.charAt(k) != needle.charAt(j)){
                    break;
                }
                k++;
            }
            if(k == needle.length()){
                return i;
            }
        }
        return -1;
    }


    /**
     * sunday算法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }

        for(int i = 0; i < haystack.length();){
            int k = 0;
            for(int j = 0; j < needle.length(); j++){
            }

        }

        return -1;
    }
}
