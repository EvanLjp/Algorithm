package com.evan.leetcode.algorithm.stack_queue;

import com.evan.leetcode.LEETCODE.StackAndQueue.TreeNode;
import com.evan.leetcode.algorithm.link.classes.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by asus on 2018/1/27.
 */
public class Q144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return list;
    }


    /*public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        traversal(root,list);
        return list;


    }

    private void traversal(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        list.add(root.val);
        traversal(root.left,list);
        traversal(root.right,list);
    }*/


}
