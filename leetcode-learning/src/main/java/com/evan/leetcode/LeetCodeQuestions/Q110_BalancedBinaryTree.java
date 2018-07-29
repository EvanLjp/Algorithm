package com.evan.leetcode.LeetCodeQuestions;

import LEETCODE.StackAndQueue.TreeNode;

/**
 * @Auther:Evan
 * @Description:
 * @CreateDate: 2018/4/16 15:47
 */
public class Q110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)!=-1;
    }

    private int  maxDepth(TreeNode root) {
        if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;

    }




}
