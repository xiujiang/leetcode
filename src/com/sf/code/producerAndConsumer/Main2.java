package com.sf.code.producerAndConsumer;


public class Main2 {

    public static void main(String[] args) {
        System.out.println(add("123","345"));
    }

    public static String add(String a,String b){
        if(!canAdd(a) && !canAdd(b)){
            return null;
        }
        String c = "";
        int i = a.length()-1;
        int j = b.length()-1;
        int count = 0;
        while(i >= 0 || j >=0 || count > 0){
            i = (i >= 0 && a.charAt(i) >='0' && a.charAt(i) <='9') ? a.charAt(i) - '0' : 0;
            j = (j >= 0 && b.charAt(j) >='0' && b.charAt(j) <='9') ? b.charAt(j) - '0' : 0;
            int res = i + j + count;
            if(res > 10){
                count = 1;
                res = res-10;
            }
            c = res + c;
            i--;
            j--;
        }
        if(count > 0){
            c = count + c;
        }
        return c;
    }


    public static boolean canAdd(String str){
        if(str == null || str.length() == 0){
            return false;
        }
        int k = 0;
        for(int i = 0; i < str.length(); i++){
            if(i > 0 && (str.charAt(i) < '0' || str.charAt(i) > '9')){
                return false;
            }
            if(i == 0 && (str.charAt(i) < '0' || str.charAt(i) > '9') && str.charAt(i) != '+' && str.charAt(i) != '-'){
                return false;
            }
        }
        return true;
    }
}
