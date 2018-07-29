package com.evan.leetcode.LeetCodeQuestions;


import com.evan.leetcode.LEETCODE.StackAndQueue.TreeNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/4/17 20:46
 */
public class Q129_SumRoottoLeafNumbers {

    int res=0;
    public int sumNumbers(TreeNode root) {
        getRes(root,0);
        return res;
    }

    private void getRes(TreeNode root, int i) {
        if(root==null) return;
        if(root.left==null&&root.right==null) {
            res+=(i*10+root.val);
            return;
        }
        getRes(root.left,i*10+root.val);
        getRes(root.right,i*10+root.val);
    }

}
