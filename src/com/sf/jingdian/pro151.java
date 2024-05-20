package com.sf.jingdian;


public class pro151 {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuffer sbf = new StringBuffer();
        for (int i = strs.length-1; i >= 0; i--) {
            if(" ".equals(strs[i]) || strs[i].length() == 0){
                continue;
            }
            sbf.append(strs[i].trim()+" ");
        }
        return sbf.toString().trim();
    }

    static void print(Object[] num){
        for(int i = 0; i < num.length; i++){
            if(num[i].toString().length() == 0){
                System.out.print("11");
            }
            System.out.println(num[i]);
        }
    }
}
