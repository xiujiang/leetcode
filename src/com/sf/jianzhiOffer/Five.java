package com.sf.jianzhiOffer;


import java.util.ArrayList;
import java.util.Stack;

public class Five {
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
}
