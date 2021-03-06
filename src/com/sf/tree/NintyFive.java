package com.sf.tree;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 *  
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *  
 *
 * 提示：
 *
 * 0 <= n <= 8
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NintyFive {
    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(3);
        treeNodes.forEach(o->{
            TreeNode.print(o);
        });
    }
    static List<TreeNode> treeNodes = new ArrayList<>();
    public static List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return getTreeNodes(1,n);
    }

    public static List<TreeNode> getTreeNodes(int start,int end) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        //不满足二叉搜索树性质就退出
        if(start > end){
            treeNodes.add(null);
            return treeNodes;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = getTreeNodes(start,i-1);
            List<TreeNode> right = getTreeNodes(i+1,end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    treeNodes.add(root);
                }
            }
        }
        return treeNodes;
    }
}
