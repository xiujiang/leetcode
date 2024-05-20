package com.sf.jingdian;

import java.util.HashMap;
import java.util.Map;

public class pro138 {
    public static void main(String[] args) {


    }

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Map<Node,Node> nodeMap = new HashMap<>();
        if(!nodeMap.containsKey(head)){
            Node tmp = new Node(head.val);
            nodeMap.put(head,tmp);
            tmp.next = copyRandomList(head.next);
            tmp.random = copyRandomList(head.random);
        }
        return nodeMap.get(head);
    }
}
