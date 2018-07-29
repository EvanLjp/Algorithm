package com.evan.leetcode.LEETCODE.TreeAndRecursion;

import org.junit.Test;

/**
 * Created by asus on 2018/2/6.
 */
public class LowestCommonAncestorofaBinarySearchTree_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        else if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        return root;
    }


    @Test
    public void test() {
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(4);
        TreeNode a8 = new TreeNode(1);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a4.left = a8;
        System.out.println(lowestCommonAncestor(a1, a8, a5).val);


    }


}
