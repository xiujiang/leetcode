package com.sf.tree;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwentySeven {
    public static void main(String[] args) {

    }
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode mirrorRoot = root;
        mirrorRoot = getMirrorTree(root,mirrorRoot);
        return mirrorRoot;
    }

    public TreeNode getMirrorTree(TreeNode root,TreeNode mirrorTree){
        if(root == null){
            return null;
        }
        mirrorTree = new TreeNode(root.val,null,null);
        mirrorTree.right = getMirrorTree(root.left,mirrorTree);
        mirrorTree.left = getMirrorTree(root.right,mirrorTree);
        return mirrorTree;
    }
}
