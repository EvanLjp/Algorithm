package com.evan.leetcode.algorithm.treerecursion;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;
import org.junit.Test;

/**
 * Created by asus on 2018/2/6.
 */
public class Q98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < max && root.val > min) {
            return isBST(root.left, min, Math.min(max, root.val)) && isBST(root.right, Math.max(min, root.val), max);
        } else {
            return false;
        }
    }

    @Test
    public void test(){
        TreeNode a=new TreeNode(1);
        System.out.println(isValidBST(a));


    }


}
