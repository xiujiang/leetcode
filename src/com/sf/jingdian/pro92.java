package com.sf.jingdian;

public class pro92 {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int total = 0;
        ListNode finalNode = head;
        ListNode tmp = head;
        ListNode newHead = null;
        if(left == right){
            return head;
        }
        int index = 1;
        while(tmp != null){
            if(index >= left && index <= right){
                if(newHead == null){
                    newHead = new ListNode(tmp.val);
                }else{
                    ListNode node = new ListNode(tmp.val);
                    node.next = newHead;
                    newHead = node;
                }
            }
            index++;
            tmp = tmp.next;
        }
        int start = 1;
        while(newHead != null){
            if(start >= left && start <= right){
                head.val = newHead.val;
                newHead = newHead.next;
            }
            start++;
            head = head.next;

        }
        return finalNode;
        //1,2,3,4,5
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
