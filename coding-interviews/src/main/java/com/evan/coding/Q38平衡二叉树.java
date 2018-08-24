package com.evan.coding;

import com.evan.interviews.some_used_class.TreeNode;

/**
 * @author :evan
 * @date :2018-08-21 16:52
 **/
public class Q38平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getDepth(root) != -1;

    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        if ( Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }
}
