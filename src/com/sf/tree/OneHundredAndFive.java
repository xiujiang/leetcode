package com.sf.tree;

import com.sf.tree.NintyFour;
import com.sf.tree.TreeNode;

import java.util.List;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndFive {
    public static void main(String[] args) {
        int [] preorder = new int[]{1,2,3};
        int[] inorder = new int[]{3,2,1};
        List<Integer> integers = NintyFour.inorderTraversal1(buildTree(preorder, inorder));
        integers.forEach(o->{
            System.out.println(o);
        });
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode tree = new TreeNode();
        tree = build1(preorder,inorder,0,preorder.length-1,0,inorder.length-1,tree);
//        build(preorder,inorder,tree);
        return tree;
    }

//    // 先把根节点建立出来
//    TreeNode root = new TreeNode(preorder[preorder_root]);
//    // 得到左子树中的节点数目
//    int size_left_subtree = inorder_root - inorder_left;
//    // 递归地构造左子树，并连接到根节点
//    // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
//    root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
//    // 递归地构造右子树，并连接到根节点
//    // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
//    root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
//        return root;
//

    public static TreeNode build1(int[] preorder, int[] inorder,int pl,int pr,int il,int ir,TreeNode treeNode){
        if(pl > pr){
            return null;
        }
        if(pl >= preorder.length){
            return null;
        }
        treeNode.val = preorder[pl];
        if(pl == pr || il == ir){
            return treeNode;
        }
        Integer root = pr;
        for(int i = il; i <= ir; i++){
            if(inorder[i] == treeNode.val){
                root = i;
                break;
            }
        }
        if(root == null){
            return null;
        }
        System.out.println(" a "+root);

        treeNode.left = build1(preorder,inorder,pl+1,root,il,root-1,new TreeNode());
        treeNode.right = build1(preorder,inorder,root+1,pr,root+1,ir,new TreeNode());
        return treeNode;
    }

    public static TreeNode build(int[] preorder, int[] inorder,TreeNode treeNode){
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        treeNode.val = preorder[0];
        if(preorder.length == 1){
            return treeNode;
        }
        Integer root = null;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == treeNode.val){
                root = i;
                break;
            }
        }
        int l = 0,r=0;
        int[] prer = new int[preorder.length-(root+1)];
        int[] prel = new int[root];
        for(int i = 1; i < preorder.length; i++){
            if(i > root){
                prer[r++] = preorder[i];
            }else if(i <=root){
                prel[l++] = preorder[i];
            }
        }
        int[] left = new int[root];
        int[] right = new int[inorder.length-root-1];
        l = 0;
        r=0;
        for(int i = 0; i < inorder.length; i++){
            if(i < root){
                left[l++] = inorder[i];
            }else if(i > root){
                right[r++] = inorder[i];
            }
        }
        treeNode.left = build(prel,left,new TreeNode());
        treeNode.right = build(prer,right,new TreeNode());
        return treeNode;
    }


}
