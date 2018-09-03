package com.evan.leetcode.algorithm.treerecursion;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

/**
 * Created by asus on 2018/2/5.
 */
public class Q222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root==null) {
            return 0;
        }
        TreeNode left=root.left;
        TreeNode right=root.right;
        int depthL=1;
        while (left!=null&&right!=null){
            depthL++;
            left=left.left;
            right=right.right;
        }
       if(left==null){
            return (1<<depthL)-1;
       }
       return 1+countNodes(root.left)+countNodes(root.right);


    }


}
