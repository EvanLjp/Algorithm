package com.evan.leetcode.algorithm.treerecursion;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

/**
 * Created by asus on 2018/2/4.
 */
public class Q111MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode root) {
        if (root == null){
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;


    }


}
