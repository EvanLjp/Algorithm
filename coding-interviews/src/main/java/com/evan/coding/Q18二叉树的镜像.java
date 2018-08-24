package com.evan.coding;

import com.evan.interviews.some_used_class.TreeNode;

/**
 * @author :evan
 * @date :2018-08-20 14:13
 **/
public class Q18二叉树的镜像 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);

    }


}
