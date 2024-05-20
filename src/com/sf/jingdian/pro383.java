package com.sf.jingdian;

public class pro383 {
    public static void main(String[] args) {

    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] m = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            m[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0; i < ransomNote.length(); i++){
            if(m[ransomNote.charAt(i) - 'a']-- == 0){
                return false;
            }
        }
        return true;
    }
}
