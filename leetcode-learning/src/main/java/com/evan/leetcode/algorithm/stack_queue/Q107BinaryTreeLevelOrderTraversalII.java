package com.evan.leetcode.algorithm.stack_queue;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author :evan
 * @date :2018-08-15 17:14
 **/
public class Q107BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List list = new LinkedList();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> res = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                res.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            stack.add(res);
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }


}
