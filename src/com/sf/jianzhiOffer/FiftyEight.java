package com.sf.jianzhiOffer;

/**
 * 二叉树的下一个节点
 */
public class FiftyEight {

    static int flag = 0;
    public static TreeNode findNext(TreeNode root,TreeNode t){
        if(root == null || t == null){
            return null;
        }
        return find(root,t);
    }

    public static TreeNode find(TreeNode root,TreeNode t){
        if(root == null){
            return null;
        }
        if(root.val == t.val){
            flag = 1;
            return null;
        }
        find(root.left,t);
        if(flag == 1){
            return root;
        }
        find(root.right,t);
        return null;
    }
}
