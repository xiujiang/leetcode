package com.sf.jianzhiOffer;

/**
 * 求链表中倒数第 K 个节点
 */
public class fiveteen {

    public  ListNode findK(ListNode head,int k){
        if(head == null || k <=0){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(k-- > 1){
            if(fast.next == null){
                return null;
            }
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
