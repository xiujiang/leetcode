package com.sf.jingdian;

public class pro3 {
    public static void main(String[] args) {
        String s = "";
        System.out.println(lengthOfLongestSubstring(s));

        a:
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if (i == 5){
                    break a;
                }
            }
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        int right = 0;
        int max = 0;
        String subStr = "";
        for(right = 0; right < s.length(); right++){
            int index = subStr.indexOf(s.charAt(right));
            if(index != -1){
                max = Math.max(max,subStr.length());
                subStr = subStr.substring(index + 1) + s.charAt(right);
            }else{
                subStr += s.charAt(right);
                max = Math.max(max,subStr.length());
            }

        }
        return max;
    }



}
