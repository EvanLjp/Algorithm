package com.evan.leetcode.algorithm.stack_queue;


import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by asus on 2018/1/28.
 */
public class Q102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> res = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                res.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            lists.add(res);
        }
        return lists;

    }


}
