package com.evan.leetcode.algorithm.stack_queue;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

import java.util.*;

/**
 * @author :evan
 * @date :2018-08-15 17:39
 **/
public class Q199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (i == 0) {
                    list.add(treeNode.val);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
            }
        }
        return list;
    }

}
