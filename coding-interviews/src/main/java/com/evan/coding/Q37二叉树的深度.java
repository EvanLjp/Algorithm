package com.evan.coding;

import com.evan.interviews.some_used_class.TreeNode;

/**
 * @author :evan
 * @date :2018-08-21 16:48
 **/
public class Q37二叉树的深度 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

}
