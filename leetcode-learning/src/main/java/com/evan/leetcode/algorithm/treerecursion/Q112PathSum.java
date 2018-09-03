package com.evan.leetcode.algorithm.treerecursion;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

/**
 * Created by asus on 2018/2/5.
 */
public class Q112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) {
            return false;
        }
        if(root.left==null&&root.right==null&&root.val==sum) {
            return true;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);



    }

















}
