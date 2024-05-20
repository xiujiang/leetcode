package com.sf.jianzhiOffer;

/**
 * 构建乘积数组
 */
public class FiftyTwo {

    public static void main(String[] args) {

    }

    public ListNode delete(ListNode head){
        if(head == null){
            return head;
        }
        ListNode temp = null;
        while(head != null){
            temp = head.next;
            while(temp != null && head.val == temp.val){
                temp = temp.next;
            }
            head.next = temp;
        }
        return head;
    }
}
