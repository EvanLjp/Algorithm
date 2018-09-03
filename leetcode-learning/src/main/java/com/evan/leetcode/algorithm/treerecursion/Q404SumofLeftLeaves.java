package com.evan.leetcode.algorithm.treerecursion;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

/**
 * Created by asus on 2018/2/5.
 */
public class Q404SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {

        return sumLeft(root, false);

    }

    private int sumLeft(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && flag) {
            return root.val;
        }
        return sumLeft(root.left, true) + sumLeft(root.right, false);
    }
}
