package com.sf.jianzhiOffer;

import java.util.Stack;

/**
 * 二叉树的镜像
 */
public class ninteen {

    public TreeNode revert(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val,null,null);
        newRoot.left = revert(root.right);
        newRoot.right = revert(root.left);
        return newRoot;
    }

    public TreeNode revert2(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
        }
        return null;
    }
}
