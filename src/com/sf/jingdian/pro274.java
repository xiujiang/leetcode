package com.sf.jingdian;

public class pro274 {
    public static void main(String[] args) {
        int[] ci = {3,0,6,1,5};
        System.out.println(hIndex(ci));
    }

    public static int hIndex(int[] citations) {

        for(int i = 0; i < citations.length; i++){
            for(int j = i+1; j < citations.length; j++){
                if(citations[i] > citations[j]){
                    int tmp = citations[i];
                    citations[i] = citations[j];
                    citations[j] = tmp;
                }
            }
        }
        int h = 0;
        for(int i = citations.length-1; i >= 0; i--){
            if(citations[i] > h){
                h++;
            }
        }
        return h;
    }

    static void print(int[] num){
        for(int i = 0; i < num.length; i++){
            System.out.print(num[i]);
        }
        System.out.println();
    }
}
