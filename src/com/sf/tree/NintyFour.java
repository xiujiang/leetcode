package com.sf.tree;

import com.sf.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 *
 *                 10
 *             3       4
 *         2         5
 *       1   0     7   6
 */
public class NintyFour {
    static List<Integer> list = new ArrayList();

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
//中        1  2  0  3  10  7  5  6  4
//前        10  3  2  1  0  4  5  7  6
        root.val = 10;
        root.left = new TreeNode(3,new TreeNode(2,new TreeNode(1,null,null),new TreeNode(0,null,null)),null);
        root.right = new TreeNode(4,new TreeNode(5,new TreeNode(7,null,null),new TreeNode(6,null,null)),null);
        inorderTraversal3(root);
        list.forEach(o-> System.out.print(o+"  "));
    }

    /**
     * 中序
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        if(root.left != null){
            getVal(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            getVal(root.right);
        }
        return list;
    }

    /**
     * 前序  非递归   根左右
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root){
        Stack<TreeNode> st = new Stack();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode pop = st.pop();
            if(pop == null){
                continue;
            }
            st.push(pop.right);
            st.push(pop.left);
            list.add(pop.val);
        }
        return list;
    }

    /**
     * 中序  非递归   左根右
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        Stack<TreeNode> st = new Stack();
        TreeNode p = root;
        while(p != null || !st.isEmpty()){
            while(p != null){
                st.push(p);
                p = p.left;
            }
            if(!st.isEmpty()){
                TreeNode pop = st.pop();
                list.add(pop.val);
                p = pop.right;
            }
        }
        return list;
    }

    /**
     *  后序
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal3(TreeNode root){
        Stack<TreeNode> st1 = new Stack();
        Stack<Integer> st2 = new Stack();
        int left = 1;
        int right = 2;
        TreeNode p = root;
        while(p != null || !st1.isEmpty()){
            while(p!=null){
                st1.add(p);
                st2.add(left);
                p = p.left;
            }
            if(!st1.isEmpty() && st2.peek() == right){
                TreeNode pop = st1.pop();
                list.add(pop.val);
                st2.pop();
            }
            if(!st1.isEmpty() && st2.peek() == left){
                p = st1.peek().right;
                st2.pop();
                st2.push(right);
            }
        }
        return list;
    }



    public static void getVal(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            getVal(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            getVal(root.right);
        }
    }
    public static void clear(){
        list.clear();
    }
}



