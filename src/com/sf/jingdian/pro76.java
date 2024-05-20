package com.sf.jingdian;

import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pro76 {
    public static void main(String[] args) {
        String s = "kgfidhktkjhlkbgjkylgdracfzjduycghkomrbfbkoowqwgaurizliesjnveoxmvjdjaepdqftmvsuyoogobrutahogxnvuxyezevfuaaiyufwjtezuxtpycfgasburzytdvazwakuxpsiiyhewctwgycgsgdkhdfnzfmvhwrellmvjvzfzsdgqgolorxvxciwjxtqvmxhxlcijeqiytqrzfcpyzlvbvrksmcoybxxpbgyfwgepzvrezgcytabptnjgpxgtweiykgfiolxniqthzwfswihpvtxlseepkopwuueiidyquratphnnqxflqcyiiezssoomlsxtyxlsolngtctjzywrbvajbzeuqsiblhwlehfvtubmwuxyvvpwsrhutlojgwktegekpjfidgwzdvxyrpwjgfdzttizquswcwgshockuzlzulznavzgdegwyovqlpmnluhsikeflpghagvcbujeapcyfxosmcizzpthbzompvurbrwenflnwnmdncwbfebevwnzwclnzhgcycglhtbfjnjwrfxwlacixqhvuvivcoxdrfqazrgigrgywdwjgztfrbanwiiayhdrmuunlcxstdsrjoapntugwutuedvemyyzusogumanpueyigpybjeyfasjfpqsqotkgjqaxspnmvnxbfvcobcudxflmvfcjanrjfthaiwofllgqglhkndpmiazgfdrfsjracyanwqsjcbakmjubmmowmpeuuwznfspjsryohtyjuawglsjxezvroallym";
        String t = "abcddasdfasdfagsadfasdf";
        Long st = System.currentTimeMillis();
        System.out.println(minWindow(s,t));
        List<Integer> i = new ArrayList<>();
        System.out.println(i.add(1));
        System.out.println(0 / 3);
        char c = 'a';
        String.valueOf(c);

        Map<String,List> map = new HashMap<>();
        System.out.println(map.get("0"));
        System.out.println(System.currentTimeMillis() - st);
    }

    public static String minWindow(String s, String t){
        int start = 0;
        int end = 0;
        int[][] a = new int[52][1];
        int[][] temp = new int[52][1];
        String subStr = "";
        for(int i = 0; i < t.length(); i++){
            a[getIndex(t.charAt(i))][0] += 1;
        }
        while(end < s.length()){
            char c = s.charAt(end);
            temp[getIndex(c)][0] += 1;
            while((end - start + 1) >= t.length() && isArrEquals(a, temp)){
                subStr = (subStr.length() == 0 || subStr.length() > (end - start + 1)) ? s.substring(start,end+1) : subStr;
                temp[getIndex(s.charAt(start++))][0] -= 1;
            }
            end++;
        }
        return subStr;
    }

    private static int getIndex(char a){
        return a >= 'a' ? a - 'a' + 26 : a - 'A';
    }
    private static boolean isArrEquals(int[][] a,int [][] temp){
        for(int i = 0; i < temp.length; i++){
            if(a[i][0] > 0 && a[i][0] > temp[i][0]){
                return false;
            }
        }
        return true;
    }


    public static String minWindow1(String s, String t) {
        int start = -1;
        String subStr = "";
        if(s.length() <= t.length()){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> tmpMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
            tmpMap.put(t.charAt(i),0);
        }

        for(int i = 0; i < s.length(); i++){
            if(tmpMap.containsKey(s.charAt(i))){
                tmpMap.put(s.charAt(i),tmpMap.getOrDefault(s.charAt(i),0)+1);
                start = start == -1 ? i : start;
            }
            if (isEquals(map,tmpMap)) {
                subStr = subStr.length() < (i - start + 1) && subStr.length() > 0 ? subStr :s.substring(start,i + 1);
                tmpMap = new HashMap<>();
                for(int j = 0; j < t.length(); j++){
                    tmpMap.put(t.charAt(j),0);
                }
                i = start;
                start = -1;
            }

        }
        return subStr;
    }

    private static boolean isEquals(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2){
        for (Character character : map1.keySet()) {
            if(map2.get(character) < map1.get(character)){
                return false;
            }
        }
        return true;
    }
}
