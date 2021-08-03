package com.sf.jianzhiOffer;

/**
 *
 * 替换字符串中空格
 */
public class Four {
    public static void main(String[] args) {
        String s = "We are fithing";
        String s1 = replaceSpace(s);
        System.out.println(s1);
    }

    private static String replaceSpace(String s){
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                sbf.append("%20");
            }else{
                sbf.append(s.charAt(i));
            }
        }
        return sbf.toString();
    }
}
