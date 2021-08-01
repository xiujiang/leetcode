package com.sf.lianbiao;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[][] num = new int[100][100];
        int n = 4; int count =1;
//        for(int i=0;i<n;i++) {
//            for (int j = 0; j < n; j++) {
//                num[i][j] = count++;
//                System.out.print(num[i][j] + "  ");
//            }
//            System.out.println();
//        }
//        print(num,0,n-1);
        int[] x = new int[]{1,2,3,4,5,6,7,8,9,10};
        findSum(x,9);
    }


    public static void revertList(ListNode root){
        ListNode temp = root;
        ListNode cur;
        root = null;
        while(temp != null){
           cur = temp.next;
           temp.next = root;
           root = temp;
           temp = cur;
        }
    }

    private static void stackReverList(ListNode head){
        Stack<Integer> stack = new Stack();
        while(head != null){
            stack.add(head.val);
            head = head.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < stack.size(); i++){
            list.add(stack.pop());
        }
    }


    class ListNode{
//        private ListNode pre;
        private ListNode next;
        private int val;
    }


    public static void print(int[][] x,int start,int end){
        if (start >= end || end <=0) {
            return;
        }
        for(int i = start; i <= end; i++){
            System.out.println(x[start][i]);
        }
        for(int i = start+1; i <= end; i++){
            System.out.println(x[i][end]);
        }
        for (int i = end - 1; i >= start; i--){
            System.out.println(x[end][i]);
        }
        for(int i = end - 1; i > start; i--){
            System.out.println(x[i][start]);
        }
        print(x,start+1,end-1);
    }

    public static void findSum(int[] num,int s){
        int x = 0;
        int k = 0;
        for(int i = 0; i < num.length; i++){
            if(x > s){
                x -= num[k];
                k++;
            }
            if(x == s){
                for(int j = k; j < i; j++){
                    System.out.print(num[j]+ "  ");
                }
                x =0;
                k = i;
                System.out.println();
            }
            x+=num[i];
            if(num[i] > s){
                break;
            }
        }

    }
}
