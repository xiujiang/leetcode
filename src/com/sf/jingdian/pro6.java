package com.sf.jingdian;

public class pro6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s,3));
    }

    public static String convert(String s, int numRows) {
        boolean flag = false;
        StringBuffer sbf = new StringBuffer();
        StringBuffer[] res = new StringBuffer[numRows];
        int i = 0;
        int j = 0;
        if(s.length() < numRows){
            return s;
        }
        while(i < s.length()){
            if(res[j] == null){
                res[j] = new StringBuffer();
            }
            res[j] = res[j].append(s.charAt(i));
            if(j == 0 || j == (numRows - 1)){
                flag = !flag;
            }
            if(flag){
                j++;
            }else{
                j--;
            }
            i++;
        }
        for (StringBuffer re : res) {
            sbf.append(re.toString());
        }
        return sbf.toString();
    }
}
