package com.evan.leetcode.algorithm.treerecursion;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

/**
 * Created by asus on 2018/2/4.
 */
public class Q226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode right = root.right;
            root.right = root.left;
            root.left = right;
        }
        return root;
    }


}
