package com.evan.interviews;

import GetOffers.some_used_class.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 22:40
 */
public class Q32_3按之字形顺序打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            if (!stack1.isEmpty()) {
                int size = stack1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = stack1.pop();
                    list.add(pop.val);
                    if (pop.left != null) stack2.push(pop.left);
                    if (pop.right != null) stack2.push(pop.right);

                }
            } else {
                int size = stack2.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = stack2.pop();
                    list.add(pop.val);
                    if (pop.right != null) stack1.push(pop.right);
                    if (pop.left != null) stack1.push(pop.left);
                }
            }
            res.add(list);
        }
        return res;


    }


}
