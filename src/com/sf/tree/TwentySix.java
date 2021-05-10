package com.sf.tree;

import com.sf.tree.NintyFour;
import com.sf.tree.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwentySix {
    public static void main(String[] args) throws InterruptedException {
        //A = [1,2,3], B = [3,1]
        TreeNode A = new TreeNode(3,new TreeNode(1,null,null),new TreeNode(2,null,null));
        TreeNode B = new TreeNode(3,new TreeNode(1,null,null),null);
        System.out.println(isSubStructure(A,B));
    }
    public static boolean isSubStructure(TreeNode A, TreeNode B) throws InterruptedException {
        if(A == null || B == null){
            return false;
        }
        return isEqual(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public static boolean isEqual(TreeNode a,TreeNode b){
        if(b == null){
            return true;
        }
        if(a == null){
            return false;
        }
        return a.val == b.val && isEqual(a.left,b.left) && isEqual(a.right,b.right);
    }
    public static void print(TreeNode a,TreeNode b){
        NintyFour.clear();
        System.out.print(NintyFour.inorderTraversal1(a)+"  ");
        NintyFour.clear();
        System.out.println(NintyFour.inorderTraversal1(b));

    }
}


