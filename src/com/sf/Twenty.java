package com.sf;

import java.util.Queue;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Twenty {

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
    public static boolean isValid(String s) {
        if(s.length() == 0 || s.length() % 2 != 0){
            return false;
        }
        char[] c = new char[s.length()];
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            c[j++] = s.charAt(i);
            if(j >= 2){
                if(c[j-1] - c[j-2] <= 2 && c[j-1] - c[j-2] > 0){
                    j -=2;
                    continue;
                }
            }

        }
        if(j == 0){
            return true;
        }

        return false;
    }
}
