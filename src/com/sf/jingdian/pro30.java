package com.sf.jingdian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pro30 {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String [] words = {"bar","foo","the"};
        System.out.println(findSubstring(s,words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int wordLength = 0;

        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
            wordLength = word.length();
        }
        int totalLength = words.length * wordLength;
        for(int i = 0; i < s.length() - totalLength + 1; i++){
            Map<String,Integer> tmp_map = new HashMap<>();
            for(int j = i; j < i + totalLength; j+=wordLength){
                String tmpStr = s.substring(j,j+wordLength);
                tmp_map.put(tmpStr,tmp_map.getOrDefault(tmpStr,0)+1);
            }
            if(tmp_map.equals(map)){
                list.add(i);
            }
        }
        return list;
    }

}
