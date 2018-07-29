package com.evan.leetcode.LEETCODE.TreeAndRecursion;

/**
 * Created by asus on 2018/2/4.
 */
public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSameTree(root.left,root.right);
    }

    private boolean isSameTree(TreeNode left, TreeNode right) {
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        if(left.val==right.val){
            return isSameTree(left.left,right.right)&&isSameTree(left.right,right.left);
        }else return false;

    }


}
