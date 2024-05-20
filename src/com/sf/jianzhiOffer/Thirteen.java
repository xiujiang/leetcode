package com.sf.jianzhiOffer;

/**
 * O(1)时间删除链表节点
 */
public class Thirteen {
    public void deleteNode(ListNode head, ListNode deListNode) { if (deListNode == null || head == null) {
        return;
    }
        if (head == deListNode) {
            head = null;
        }else {
// 若删除节点是末尾节点，往后移一个
            if (deListNode.next == null) {
                ListNode pointListNode = head;
                while (pointListNode.next.next != null) {
                    pointListNode = pointListNode.next;
                }
                pointListNode.next = null;
            }else {
            deListNode.val = deListNode.next.val;
            deListNode.next = deListNode.next.next; }
    } }
}
