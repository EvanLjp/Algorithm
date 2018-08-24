package com.evan.interviews;


import com.evan.interviews.some_used_class.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 22:18
 */
public class Q32_1_从上往下打印二叉树 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null) queue.add(poll.left);
                if(poll.right!=null) queue.add(poll.right);
            }
        }
        return list;
    }






}
