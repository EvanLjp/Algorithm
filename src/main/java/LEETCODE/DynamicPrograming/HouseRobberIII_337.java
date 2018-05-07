package LEETCODE.DynamicPrograming;


import LEETCODE.StackAndQueue.TreeNode;

/**
 * Created by asus on 2018/2/18.
 */
public class HouseRobberIII_337 {
    /**
     * 递归
     * @param root
     * @return
     */
    public int rob_1(TreeNode root) {
        int[] arr=getMoney(root);
        return Math.max(arr[0],arr[1]);
    }

    private int[] getMoney(TreeNode root) {
        if(root==null) return new int[]{0,0};
        int []arr=new int[2];
        int[] left=getMoney(root.left);
        int[] right=getMoney(root.right);
        arr[0] =Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        arr[1]=root.val+left[0]+right[0];
        return arr;
    }



}
