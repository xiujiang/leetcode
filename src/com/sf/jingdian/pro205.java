package com.sf.jingdian;

public class pro205 {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s,t));
    }

    public static boolean isIsomorphic(String s, String t) {
        char[][] strIndex = new char[26][1];
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            if(strIndex[s.charAt(i) - 'a'][0] == '\u0000' && strIndex[t.charAt(i) - 'a'][0] == '\u0000'){
                strIndex[s.charAt(i) - 'a'][0] = t.charAt(i);
                strIndex[t.charAt(i) - 'a'][0] = s.charAt(i);
            }else{
                if(strIndex[s.charAt(i)- 'a'][0] != t.charAt(i)){
                    System.out.println(strIndex[s.charAt(i) - 'a'][0]+"  "+t.charAt(i));
                    return false;
                }
            }
        }
        return true;
    }
    //a b c d e f g h i j k l m n o p q r s t u v w x y z
}
