package com.sf.jianzhiOffer;


/**
 * 判断二叉树 A 中是否包含子树 B
 */
public class eighteen {

    public static void main(String[] args) {

    }
    public static boolean adjust(TreeNode a,TreeNode b){
        if(b == null){
            return true;
        }
        if(a != null){
            return false;
        }
        if(a == b){
            return true;
        }
        return a.val == b.val && adjust(a.left,b.left) && adjust(a.right ,b.right);
    }
}
