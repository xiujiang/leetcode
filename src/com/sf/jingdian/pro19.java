package com.sf.jingdian;

public class pro19 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = 0;
        ListNode tmp = head;
        while(tmp != null){
            total++;
            tmp = tmp.next;
        }
        int start = 1;
        //1 2 3 4 5
        ListNode newNode = null;
        if(total - n < 1){
            return head.next;
        }else{
            newNode = head;
        }
        while(head != null){
            if(start == total - n){
                head.next = head.next.next;
                head = head.next;
            }
            start++;
            head = head != null ? head.next : null;
        }

        return newNode;
    }
}
