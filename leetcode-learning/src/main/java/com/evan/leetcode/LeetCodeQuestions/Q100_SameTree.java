package com.evan.leetcode.LeetCodeQuestions;


import com.evan.leetcode.LEETCODE.StackAndQueue.TreeNode;

/**
 * @Auther:Evan
 * @Description:
 * @CreateDate: 2018/4/16 14:08
 */
public class Q100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null){
            if(p==null&&q==null) return true;
            return false;
        }
        if(p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
        return false;
    }


}
