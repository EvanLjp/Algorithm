package com.evan.leetcode.algorithm.treerecursion;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;
import org.junit.Test;

/**
 * Created by asus on 2018/2/8.
 */
public class Q230KthSmallestElementinaBST {

    private int count;
    private int res;
    private boolean flag = false;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorderSearch(root);
        return res;
    }

    private void inorderSearch(TreeNode root) {
        if (flag || root == null) {
            return;
        }
        inorderSearch(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            flag = true;
        }
        inorderSearch(root.right);


    }



    /*private int res;
    private int count = 0;
    private boolean flag = false;

    public int kthSmallest(TreeNode root, int k) {
        getValue(root, k);
        return res;
    }

    private void getValue(TreeNode root, int k) {
        if (root.left != null) {
            getValue(root.left, k);
        }
        if (flag) {
            return;
        }
        count++;
        if (count == k) {
            res = root.val;
            flag = true;
            return;
        }
        if (root.right != null) {
            getValue(root.right, k);
        }
    }*/

    @Test
    public void test() {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        a1.right = a2;
        System.out.println(kthSmallest(a1, 2));
    }


}
