package com.evan.leetcode.LEETCODE.TreeAndRecursion;

import org.junit.Test;

/**
 * Created by asus on 2018/2/5.
 */
public class PathSumIII_437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return containPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int containPath(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) res++;
        res += containPath(root.left, sum - root.val);
        res += containPath(root.right, sum - root.val);
        return res;
    }

    @Test
    public void test() {
        TreeNode a1 = new TreeNode(10);
        TreeNode a2 = new TreeNode(5);
        TreeNode a3 = new TreeNode(-3);
        TreeNode a4 = new TreeNode(3);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(11);
        TreeNode a7 = new TreeNode(3);
        TreeNode a8 = new TreeNode(-2);
        TreeNode a9 = new TreeNode(1);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.right = a6;
        a4.left = a7;
        a4.right = a8;
        a5.right = a9;
        System.out.println(pathSum(a1, 8));

    }

}
