package com.sf.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class OneHundredAndTwo {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        if(root == null){
            return list;
        }
        treeNodes.add(root);
        int i = 1;
        while(!treeNodes.isEmpty()){
            List<Integer> l = new ArrayList<>();
            while(!treeNodes.isEmpty() && i-- > 0){
                TreeNode poll = treeNodes.pollLast();
                if(poll == null){
                    continue;
                }
                l.add(poll.val);
                if(poll.left != null){
                    treeNodes.push(poll.left);
                }
                if(poll.right != null){
                    treeNodes.push(poll.right);
                }
            }
            list.add(l);
            i = treeNodes.size();
        }
        return list;
    }
}
