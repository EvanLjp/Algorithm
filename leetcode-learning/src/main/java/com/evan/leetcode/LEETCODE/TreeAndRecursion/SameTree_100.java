package com.evan.leetcode.LEETCODE.TreeAndRecursion;

/**
 * Created by asus on 2018/2/4.
 */
public class SameTree_100 {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        if (p==null || q==null)
            return false;
        if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) return true;
        else return false;

    }
}
