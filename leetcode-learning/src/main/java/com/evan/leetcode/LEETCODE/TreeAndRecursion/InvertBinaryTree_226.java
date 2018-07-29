package com.evan.leetcode.LEETCODE.TreeAndRecursion;

/**
 * Created by asus on 2018/2/4.
 */
public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);
            swap(root);
        }
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
    }


}
