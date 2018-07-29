package com.evan.leetcode.LeetCodeQuestions;

import com.evan.leetcode.LEETCODE.StackAndQueue.TreeNode;
import org.junit.Test;

/**
 * @Auther:Evan
 * @Description:
 * @CreateDate: 2018/4/16 14:15
 */
public class Q101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return (isSymmetric(root.left,root.right)) ;
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left==null&&right==null) return true;
        if(left==null||right==null||left.val!=right.val) return false;
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }



    @Test
    public void test(){
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);


        a.left=b;
        a.right=c;
        isSymmetric(a);
    }

}
