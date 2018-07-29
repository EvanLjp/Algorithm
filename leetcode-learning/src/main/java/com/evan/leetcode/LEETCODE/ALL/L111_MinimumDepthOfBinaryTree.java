package com.evan.leetcode.LEETCODE.ALL;

import LEETCODE.StackAndQueue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by asus on 2018/2/27.
 */
public class L111_MinimumDepthOfBinaryTree {
    public int run(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int depth=1;
        while (true){
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode poll = queue.poll();
                if(poll.left==null&&poll.right==null) return depth;
                if(poll.left!=null) queue.offer(poll.left);
                if(poll.right!=null) queue.offer(poll.right);
            }
            depth++;
        }


    }


}
