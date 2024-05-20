package com.sf.jingdian;

import java.util.*;

public class pro49 {
    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(s));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String s = new String(tmp);
            if(!map.containsKey(s)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s,list);
            }else{
                map.get(s).add(str);
            }
        }
        Collection<List<String>> values = map.values();
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}
