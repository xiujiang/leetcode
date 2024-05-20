package com.sf.jingdian;

public class pro25 {
    public static void main(String[] args) {
        System.out.println(1 % 5);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode top = new ListNode(-1);
        int start = 1;
        ListNode finalNode = top;
        ListNode currNode = head;
        ListNode startNode = head;
        while(head != null){
            if (start % k == 0) {
                //revert
                currNode = head;
                head = head.next;
                start++;
                currNode.next = null;
                top.next = revert(startNode);
                top = startNode;
                startNode = head;
            }else{
                start++;
                head = head.next;
            }
        }
        top.next = startNode;
        return finalNode.next;
    }

    //1 2 3 4 5
    static ListNode revert(ListNode start){
        ListNode revert = start;
        ListNode next = start.next;
        while(next != null){
            ListNode nextNode = next.next;
            next.next = revert;
            revert = next;
            next = nextNode;
        }
        return revert;
    }
}
