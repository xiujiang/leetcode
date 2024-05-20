package com.sf.jianzhiOffer;

/**
 * 将字符串转换为整数
 */
public class FouryNine {

    public static void main(String[] args) {
        int num = getNum("-3421");
        System.out.println(num);
    }
    public static int getNum(String str){
        if (str == null || str.length() == 0) {
            return 0;
        }
        int res = 0;
        boolean flag = true;
        for (int i = 0; i < str.length(); i++){
            if(i == 0){
                if(str.charAt(i) == '-'){
                    flag = false;
                    continue;
                }else if(str.charAt(i) == '+'){
                    continue;
                }else if(str.charAt(i) < 48 || str.charAt(i) > 57){
                    return 0;
                }else{
                    res = str.charAt(i)-48;
                    continue;
                }
            }else if(str.charAt(i) < 48 || str.charAt(i) > 57){
                return 0;
            }
            res = res*10+str.charAt(i)-48;
        }
        if(!flag){
            res = -res;
        }
        return res;
    }
}
