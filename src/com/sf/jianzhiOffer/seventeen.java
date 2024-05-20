package com.sf.jianzhiOffer;

import java.util.Stack;

/**
 * 合并两个有序链表
 */
public class seventeen {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
    }

    public ListNode mergeTwoLists(ListNode node1,ListNode node2){
        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }
        if(node1.val < node2.val){
            return node1.next = mergeTwoLists(node1.next,node2);
        }else{
            return node2.next = mergeTwoLists(node1,node2.next);
        }
    }

    public ListNode merge(ListNode node1,ListNode node2){
        if(node1 == null){
            return node2;
        }
        ListNode res = null;
        while(node1 != null || node2 != null){
            ListNode n1 = node1;
            ListNode n2 = node2;
            if(n1 == null){
                res.next = n2;
            }else if(n2 == null){
                if(res == null){
                    res = n1;
                }else{
                    res.next = n1;
                }
            }else if(n1.val < n2.val){
                if(res == null){
                    res = n1;
                }
                res.next = n2;
            }else{
                if(res == null){
                    res = n2;
                }
                res.next = n1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return res;
    }
}
