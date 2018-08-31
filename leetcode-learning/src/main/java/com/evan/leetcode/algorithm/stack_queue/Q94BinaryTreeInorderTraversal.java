package com.evan.leetcode.algorithm.stack_queue;


import com.evan.leetcode.LEETCODE.LINK.ListNode;
import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by asus on 2018/1/27.
 */
public class Q94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    @Test
    public void test() {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a3.right = a5;
        System.out.println(inorderTraversal(a1));


    }



    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }*/

}
