package com.evan.leetcode.algorithm.treerecursion;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;
import org.junit.Test;

/**
 * Created by asus on 2018/2/5.
 */
public class Q129SumRoottoLeafNumbers {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        getSum(root,0);
        return sum;
    }

    private void getSum(TreeNode root,int temp) {
        if (root == null) {
            return;
        }
        temp = temp * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += temp;
            return;
        }
        getSum(root.left,temp);
        getSum(root.right,temp);
    }

    @Test
    public void test() {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        a.left = b;
        System.out.println(sumNumbers(a));

    }


}
