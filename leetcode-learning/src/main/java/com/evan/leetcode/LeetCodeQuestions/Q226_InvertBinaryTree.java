package com.evan.leetcode.LeetCodeQuestions;


import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

/**
 * @Auther:Evan
 * @Description:
 * @CreateDate: 2018/4/16 14:01
 */
public class Q226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        else {
            TreeNode left=root.left;
            TreeNode right=root.right;
            root.left=invertTree(right);
            root.right=invertTree(left);
        }
        return root;
    }



}
