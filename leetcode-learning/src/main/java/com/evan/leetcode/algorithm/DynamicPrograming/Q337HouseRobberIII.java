package com.evan.leetcode.algorithm.DynamicPrograming;


import com.evan.leetcode.LEETCODE.StackAndQueue.TreeNode;

/**
 * Created by asus on 2018/2/18.
 */
public class Q337HouseRobberIII {
    /**
     * 递归
     * res[0]不偷该节点的值
     * res[1]偷节点的最大值
     * https://www.youtube.com/watch?v=-i2BFAU25Zk
     * @param root
     * @return
     */
    public int rob_1(TreeNode root) {
        int[] res=getMoney(root);
        return Math.max(res[0],res[1]);
    }

    private int[] getMoney(TreeNode root) {
        if(root==null) {
            return new int[]{0,0};
        }
        int []arr=new int[2];
        int[] left=getMoney(root.left);
        int[] right=getMoney(root.right);
        arr[0] =Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        arr[1]=root.val+left[0]+right[0];
        return arr;
    }



}
