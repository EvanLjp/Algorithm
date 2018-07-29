package com.evan.leetcode.LeetCodeQuestions;


import com.evan.leetcode.LEETCODE.StackAndQueue.TreeNode;

/**
 * @Auther:Evan
 * @Description:
 * @CreateDate: 2018/4/16 15:58
 */
public class Q112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null) {
            return root.val==sum;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }


}
