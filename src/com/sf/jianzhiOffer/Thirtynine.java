package com.sf.jianzhiOffer;

/**
 * 二叉树深度
 */
public class Thirtynine {

    public static int getDeep(TreeNode root){
        if(root == null){
            return 0;
        }

        return Math.max(getDeep(root.left),getDeep(root.right))+1;
    }

    public static boolean isBalance(TreeNode root){
        if(root == null){
            return true;
        }
        boolean flag = Math.abs(getDeep(root.left)-getDeep(root)) <=1;
        return flag || isBalance(root.left) || isBalance(root.right);
    }
}
