package com.sf.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 *
 *
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 示例 2：
 *
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * 示例 3：
 *
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * 示例 4：
 *
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EightHundredAndSeventyTwo {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        getLeaf(root1,r1);
        getLeaf(root2,r2);
        if(r1.size() != r2.size()){
            return false;
        }
        for(int i =0; i < r1.size(); i++){
            if(!r1.get(i).equals(r2.get(i))){
                return false;
            }
        }
        return true;

    }

    public void getLeaf(TreeNode treeNode,List<Integer> r){
        if(treeNode == null){
            return;
        }
        if(treeNode.left == null && treeNode.right == null){
            r.add(treeNode.val);
            return;
        }
        getLeaf(treeNode.left,r);
        getLeaf(treeNode.right,r);
    }
}
