package com.sf.jingdian;

public class Pro125 {
    public static void main(String[] args) {
        String s = ",.";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            while(start < end && !checkChar(s.charAt(start))){
                start++;
            }
            while(start < end && !checkChar(s.charAt(end))){
                end--;
            }
            System.out.println(s.charAt(start) +"  "+ s.charAt(end));

            int c1 = Character.toLowerCase(s.charAt(start++));
            int c2 = Character.toLowerCase(s.charAt(end--));
            if(c1 != c2){
                return false;
            }

        }
        return true;
    }

    private static boolean checkChar(char c){
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');

    }
}
