package com.evan.leetcode.LeetCodeQuestions;

import LEETCODE.TreeAndRecursion.TreeNode;

/**
 * @Auther:Evan
 * @Description:
 * @CreateDate: 2018/4/16 10:32
 */
public class Q111_MinimumDepthofBinaryTree {
    /**
     * 左面为空那么树高度就考虑右面,右面为空,书高度考虑左面,否则返回两面的最小值
     * @param root
     * @return
     */

    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        else  {
            if(root.left==null) return minDepth(root.right) + 1;
            else if(root.right==null) return minDepth(root.left) + 1;
            else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }


    public int minDepth_2(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
        int left = minDepth_2(root.left);
        int right = minDepth_2(root.right);
        if(left==0||right==0) return left==0?right+1:left+1;
        return Math.min(left,right)+1;
    }

}
