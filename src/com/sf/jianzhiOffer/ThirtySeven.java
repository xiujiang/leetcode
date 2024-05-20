package com.sf.jianzhiOffer;

/**
 * 两个链表的第一个公共节点
 */
public class ThirtySeven {

    public ListNode findFirst(ListNode a,ListNode b){
        if(a == b){
            return a;
        }
        while(a != b){
            a = a != null ? a.next : b;
            b = b != null ? b.next : a;
        }
        return a;
    }
}
