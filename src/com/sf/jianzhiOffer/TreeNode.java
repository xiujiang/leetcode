package com.sf.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     *   3,9,20,null,null,15,7
     *
     *      3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public static TreeNode buildTreeNode(String str){
        String[] at = str.split(",");
        for (int i =0 ; i < at.length; i++){
            if("null".equals(at[i])){
                at[i] ="-1";
            }
        }
        Integer[] arr = new Integer[at.length];
        for(int i = 0; i < at.length; i++){
            arr[i] = Integer.valueOf(at[i]);
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        TreeNode root=new TreeNode(arr[0]);
        queue.offer(root);
        int i=0;
        while(i<arr.length)
        {
            TreeNode node=queue.poll();
            if(node==null)
            {
                queue.offer(null);
                queue.offer(null);
                i+=2;
                continue;
            }
            int leftVal=arr[++i];
            int rightVal=arr[++i];
            if(leftVal!=-1)
            {
                node.left=new TreeNode(leftVal);
                queue.offer(node.left);
            }
            else
            {
                node.left=null;
                queue.offer(null);

            }
            if(rightVal!=-1)
            {
                node.right=new TreeNode(rightVal);
                queue.offer(node.right);
            }
            else
            {
                node.left=null;
                queue.offer(null);
            }
        }
        return root;
    }

    /**
     * 前序  非递归   根左右
     * @param root
     * @return
     */
    public static List<Integer> print(TreeNode root){
        List<Integer> list = new ArrayList();
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
        System.out.println();
        list.forEach(o->{
            System.out.print(o+" ");
        });
        System.out.println();
        return list;
    }
}