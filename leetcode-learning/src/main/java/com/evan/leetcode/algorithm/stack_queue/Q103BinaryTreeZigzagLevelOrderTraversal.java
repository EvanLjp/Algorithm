package com.evan.leetcode.algorithm.stack_queue;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author :evan
 * @date :2018-08-15 17:23
 **/
public class Q103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List list = new LinkedList();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> cur = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        cur.push(root);
        boolean isOrder = false;
        while (!cur.isEmpty()) {
            List<Integer> res = new LinkedList<>();
            int size = cur.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = cur.pop();
                res.add(treeNode.val);
                if (isOrder) {
                    if (treeNode.right != null) {
                        next.push(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        next.push(treeNode.left);
                    }
                } else {
                    if (treeNode.left != null) {
                        next.push(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        next.push(treeNode.right);
                    }
                }

            }
            list.add(res);
            Stack temp = cur;
            cur = next;
            next = temp;
            isOrder = !isOrder;

        }
        return list;
    }
}
