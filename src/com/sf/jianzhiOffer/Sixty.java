package com.sf.jianzhiOffer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 按之字形顺序打印二叉树
 */
public class Sixty {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1,new TreeNode(2,new TreeNode(3,null,null),null),new TreeNode(4,new TreeNode(5,null,null),null));
        printTree(a);
    }

    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> tree1 = new ArrayDeque<>();
        Stack<TreeNode> tree2 = new Stack<>();
        tree1.add(root);
        while(!tree1.isEmpty() || !tree2.isEmpty()){
            System.out.println();
                while(!tree1.isEmpty()){
                    TreeNode pop = tree1.poll();
                    System.out.print(pop.val+" ");
                    if(pop.left != null){
                        tree2.push(pop.left);
                    }
                    if(pop.right != null){
                        tree2.push(pop.right);
                    }
                }
            System.out.println();
                while(!tree2.isEmpty()){
                    TreeNode pop = tree2.pop();
                    System.out.print(pop.val+" ");
                    if(pop.left != null){
                        tree1.add(pop.left);
                    }
                    if(pop.right != null){
                        tree1.add(pop.right);
                    }
                }
        }
    }
}
