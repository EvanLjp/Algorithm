package com.evan.leetcode.LEETCODE.TreeAndRecursion;

import org.junit.Test;

/**
 * Created by asus on 2018/2/5.
 */
public class SumRoottoLeafNumbers_129 {
    private int sum = 0;
    private int temp = 0;

    public int sumNumbers(TreeNode root) {
        getSum(root);
        return sum;
    }

    private void getSum(TreeNode root) {
        if (root == null) return;
        int old = temp;
        temp = temp * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += temp;
            temp = old;
            return;
        }
        getSum(root.left);
        getSum(root.right);
        temp = old;
    }

    @Test
    public void test() {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        a.left = b;
        System.out.println(sumNumbers(a));

    }


}
