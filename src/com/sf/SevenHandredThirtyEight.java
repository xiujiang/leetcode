package com.sf;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。 (当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。)
 * 示例 1: 输入: N = 10 输出: 9
 * 示例 2:
 * 输入: N = 1234 输出: 1234
 * 示例 3:
 * 输入: N = 332 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 */
public class SevenHandredThirtyEight {

    public static void main(String[] args) {
        int a = 312;
        System.out.println(monotoneIncreasingDigits(a));
    }
    static int monotoneIncreasingDigits(int N) {
        String strNum = String.valueOf(N);
        int[] x = new int[strNum.length()];
        for(int i = 0; i < strNum.length(); i++){
            x[i] = strNum.charAt(i)-'0';
        }
        for (int i : x) {
            System.out.println(i);
        }
        int flag = strNum.length();
        for (int i = strNum.length() - 1; i > 0; i--) {
            if (x[i-1] > x[i]) {
                flag = i;
                x[i-1]--;
            }
        }
        for (int i = flag; i < strNum.length(); i++) {
            x[i] = 9;
        }
        for (int i : x) {
            System.out.print(i+" ");
        }
        return 1;
    }
}