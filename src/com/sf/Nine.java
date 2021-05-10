package com.sf;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Nine {
    public static void main(String[] args) {
        System.out.println(isPalindrome1(12321));
    }
    public static boolean isPalindrome(int x) {
        if(x == 0){
            return true;
        }
        if(x < 0 || x%10 == 0){
            return false;
        }
        String s = String.valueOf(x);
        int i = 0,j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome1(int x) {
        if(x == 0){
            return true;
        }
        if(x < 0 || x%10 == 0){
            return false;
        }
        int revert = 0;
        while(x > revert){
            revert = revert*10+x%10;
            x /=10;
        }
        return x == revert || x == revert/10;
    }
}
