package com.evan.leetcode.algorithm.treerecursion;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

/**
 * Created by asus on 2018/2/5.
 */
public class Q110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)!=-1;
    }

    private int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;

    }


}
