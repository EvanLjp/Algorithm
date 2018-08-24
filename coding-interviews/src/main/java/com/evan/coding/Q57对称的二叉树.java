package com.evan.coding;

import com.evan.interviews.some_used_class.TreeNode;

/**
 * @author :evan
 * @date :2018-08-22 15:53
 **/
public class Q57对称的二叉树 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}
