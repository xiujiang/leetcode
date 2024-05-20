package com.sf.jingdian;

import java.util.ArrayList;
import java.util.List;

public class pro68 {
    public static void main(String[] args) {
        String[] words = {"Listen","to","many,","speak","to","a","few."};
        System.out.println(fullJustify(words,6));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int tmpWidth = 0;
        String tmpStr = "";
        for(int i = 0; i < words.length; i++){
            int tmp = tmpWidth > 0 ? tmpWidth + words[i].length() + 1 : words[i].length();
            if(tmp > maxWidth){
                addStr(list,tmpStr,maxWidth,false);
                tmpWidth = words[i].length();
                tmpStr = words[i];
            }else{
                tmpStr = "".equals(tmpStr) ? words[i] : tmpStr + " " + words[i];
                tmpWidth = tmpStr.length();
            }
        }
        if(tmpWidth > 0){
            addStr(list,tmpStr,maxWidth,true);
        }
        return list;
    }

    public static void addStr(List<String> list,String str,int maxWidth,boolean isEnd){
        System.out.println(str);
        str = str.trim();
        if(str.length() < maxWidth && isEnd == false){
            int need = maxWidth - str.length();
            String[] splitStr = str.split(" ");
            int def = (splitStr.length - 1 > 0) ? need / (splitStr.length - 1) : need;
            int y = (splitStr.length - 1 > 0) ? need % (splitStr.length - 1) : 0;
            StringBuffer sbf = new StringBuffer();
            System.out.println(need+"  "+def + " "+ y + " "+ splitStr.length);
            for (int i = 0; i < splitStr.length - 1; i++) {
                sbf.append(splitStr[i] + " ");
                for (int j = 0; j < def; j++){
                    sbf.append(" ");
                }
                if(i < y && i != splitStr.length -1){
                    sbf.append(" ");
                }
            }
            sbf.append(splitStr[splitStr.length - 1]);
            if(sbf.length() < maxWidth){
                for (int j = 0; j < def; j++){
                    sbf.append(" ");
                }
            }
            list.add(sbf.toString());
        }else{
            if(isEnd){
                int need = maxWidth - str.length();
                for(int i =0; i < need; i++){
                    str += " ";
                }
            }
            list.add(str);
        }
    }

    static void print(Object[] num){
        for(int i = 0; i < num.length; i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
}
