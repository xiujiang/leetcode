package com.sf.tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThirtyTwo {
    int[] a;
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        if(root == null){
            a = new int[0];
            return a;
        }
        treeNodes.add(root);
        while(!treeNodes.isEmpty()){
            TreeNode pop = treeNodes.pop();
            if(pop != null){
                al.add(pop.val);
                if(pop.left != null){
                    treeNodes.add(pop.left);
                }
                if(pop.right != null){
                    treeNodes.add(pop.right);
                }
            }
        }
        a = new int[al.size()];
        for(int j = 0; j < al.size(); j ++){
            a[j] = al.get(j);
        }
        return a;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        if(root == null){
            return al;
        }
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root);
        while(!treeNodes.isEmpty()){
            int l = treeNodes.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(l-->0){
                TreeNode pop = treeNodes.pop();
                if(pop != null){
                    list.add(pop.val);
                    if(pop.left != null){
                        treeNodes.add(pop.left);
                    }
                    if(pop.right != null){
                        treeNodes.add(pop.right);
                    }
                }
            }
            al.add(list);
        }
        return al;
    }
}
