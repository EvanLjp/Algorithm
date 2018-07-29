package com.evan.leetcode.LEETCODE.TreeAndRecursion;

/**
 * Created by asus on 2018/2/5.
 */
public class SumofLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {

        return sumLeft(root, false);

    }

    private int sumLeft(TreeNode root, boolean flag) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null&&flag) return root.val;
        return sumLeft(root.left,true)+sumLeft(root.right,false);
    }
}
