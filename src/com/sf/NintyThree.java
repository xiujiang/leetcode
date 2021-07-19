package com.sf;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NintyThree {
    static List<String> a = new ArrayList<>();
    static List<String> b = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        a.clear();
        backTracking(0,s);
        return a;
    }

    public static void backTracking(int index,String s){
        if(b.size() > 4){
            return;
        }
        if(index >= s.length() && b.size() == 4){
            a.add(String.join(".",b));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isEffective(s,index,i)){
                b.add(s.substring(index,i+1));
            }else{
                continue;
            }
            backTracking(i+1,s);
            b.remove(b.size()-1);
        }
    }
    public static boolean isEffective(String s,int l,int r){
        String st = s.substring(l,r+1);
        if(st.startsWith("0") && st.length() > 1){
            return false;
        }
        if(st.length() > 3){
            return false;
        }
        if(Integer.valueOf(st) > 255){
            return false;
        }
        return true;
    }
}
