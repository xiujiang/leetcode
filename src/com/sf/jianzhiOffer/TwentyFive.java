package com.sf.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class TwentyFive {

    List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {

    }
    public void FindPath(TreeNode root,int k,ArrayList list,int count){
        if(root == null || count > k){
            return;
        }
        if(count == k){
            res.add(list);
        }
        list.add(root.val);
        count +=root.val;
        FindPath(root.left,k,list,count);
        FindPath(root.right,k,list,count);
        list.remove(list.size()-1);
    }
}
