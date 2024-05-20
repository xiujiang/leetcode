package com.sf.jingdian;

public class pro14 {
    public static void main(String[] args) {
        String[] strs = {"ab","a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String maxSubStr = null;
        if(strs.length <= 1){
            return strs[0];
        }
        for(int i = 0; i < strs.length; i++){
            if(maxSubStr == null){
                maxSubStr = strs[i];
                continue;
            }
            String str = checkSubStr(maxSubStr,strs[i]);
            if(str.equals("")){
                return "";
            }else{
                maxSubStr = str;
            }
        }
        return maxSubStr;
    }

    static String checkSubStr(String s1,String s2){
        String str = "";
        for(int i = 0; i < s1.length(); i++){
            if((s2.length() -1) >= i && (s1.charAt(i) == s2.charAt(i))){
                str += s1.charAt(i);
                continue;
            }
            return str;
        }
        return str;
    }
}
