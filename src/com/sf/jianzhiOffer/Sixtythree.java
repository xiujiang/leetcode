package com.sf.jianzhiOffer;

/**
 * 求二叉搜索树的第 K 小的节点
 */
public class Sixtythree {

    static int count = 0;
    static TreeNode node;
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1,new TreeNode(2,new TreeNode(3,null,null),null),new TreeNode(4,new TreeNode(5,null,null),null));
        findTree(a,1);
        System.out.println(node.val);
    }

    public static void findTree(TreeNode treeNode,int k){
        if(node != null){
            return;
        }
        if(treeNode != null){
            findTree(treeNode.left,k);
        }
        if(treeNode == null){
            return;
        }
        if(++count == k){
            node = treeNode;
        }
        if(treeNode.right != null){
            findTree(treeNode.right,k);
        }

    }
}
