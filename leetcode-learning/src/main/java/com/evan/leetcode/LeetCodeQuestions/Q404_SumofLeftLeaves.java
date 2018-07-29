package com.evan.leetcode.LeetCodeQuestions;


import com.evan.leetcode.LEETCODE.StackAndQueue.TreeNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/4/16 16:21
 */
public class Q404_SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        if (isLeave(root.left)) return root.left.val+sumOfLeftLeaves(root.right);
        else return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }

    private boolean isLeave(TreeNode left) {
        if(left==null) return false;
        if(left.left==null&&left.right==null) return true;
        else return false;
    }


    public int sumOfLeftLeaves_2(TreeNode root) {

        return sumLeft(root, false);

    }

    private int sumLeft(TreeNode root, boolean flag) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null&&flag) return root.val;
        return sumLeft(root.left,true)+sumLeft(root.right,false);
    }

}
