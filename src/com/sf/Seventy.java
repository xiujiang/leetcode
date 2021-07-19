package com.sf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Seventy {
    static HashMap map = new HashMap();
    static{
        map.put('2', new String[]{"a","b","c"});
        map.put('3',new String[]{"d","e","f"});
        map.put('4',new String[]{"g","h","i"});
        map.put('5',new String[]{"j","k","l"});
        map.put('6',new String[]{"m","n","o"});
        map.put('7',new String[]{"p","q","r","s"});
        map.put('8',new String[]{"t","u","v"});
        map.put('9',new String[]{"w","x","y","z"});
    }
    static List<String> a = new ArrayList<>();
    static StringBuffer b = new StringBuffer();

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
    public static List<String> letterCombinations(String digits) {
        if(digits.length() <=0){
            return a;
        }
        backTracking(0,digits);
        return a;
    }
    public static void backTracking(int index,String str){
        if(b.length() == str.length()){
            a.add(b.toString());
        }
        for(int i = index; i < str.length(); i++){
            String[] s = (String[]) map.get(str.charAt(i));
            if(s == null || s.length <=0){
                continue;
            }
            for(int j = 0; j < s.length; j++){
                b.append(s[j]);
                backTracking(i+1,str);
                b.delete(b.length()-1,b.length());
            }
        }
    }
}
