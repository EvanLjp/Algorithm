package com.evan.leetcode.algorithm.treerecursion;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

/**
 * Created by asus on 2018/2/8.
 */
public class Q236LowestCommonAncestorofaBinaryTree {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;

    }


}
