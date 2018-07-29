package com.evan.interviews;


import com.evan.interviews.some_used_class.TreeNode;

/**
 * Created by 荣德水 on 2018/5/13.
 */
public class Q55_2平衡二叉树 {
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }



}
