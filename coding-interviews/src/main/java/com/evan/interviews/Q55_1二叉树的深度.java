package com.evan.interviews;

import GetOffers.some_used_class.TreeNode;

/**
 * Created by 荣德水 on 2018/5/13.
 */
public class Q55_1二叉树的深度 {
    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
