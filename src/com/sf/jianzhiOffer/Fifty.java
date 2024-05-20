package com.sf.jianzhiOffer;

/**
 * 树中两个节点的最低公共祖先
 */
public class Fifty {
    public static void main(String[] args) {

    }

    public static TreeNode findNode(TreeNode root,int p,int q){
        if(root == null){
            return null;
        }
        if(root.val > p && root.val > q){
            return findNode(root.right,p,q);
        }else if(root.val < p && root.val < q){
            return findNode(root.left,p,q);
        }
        return root;
    }
}

