package com.evan.leetcode.algorithm.stack_queue;

import com.evan.leetcode.LEETCODE.StackAndQueue.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * Created by asus on 2018/1/27.
 */
public class Q145BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null, cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
            } else {
                cur = stack.pop();
                arrayList.add(cur.val);
                pre = cur;
                cur = null;
            }

        }
        return arrayList;
    }




   /* public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traversal(root.left, list);
        traversal(root.right, list);
        list.add(root.val);
    }*/

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
        System.out.println(postorderTraversal(a1));


    }

}
