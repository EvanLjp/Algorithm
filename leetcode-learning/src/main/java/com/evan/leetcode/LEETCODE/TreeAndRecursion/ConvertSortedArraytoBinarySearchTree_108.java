package com.evan.leetcode.LEETCODE.TreeAndRecursion;

import org.junit.Test;

/**
 * Created by asus on 2018/2/8.
 */
public class ConvertSortedArraytoBinarySearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getBST(nums, 0, nums.length - 1);
    }

    private TreeNode getBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getBST(nums, start, mid - 1);
        root.right = getBST(nums, mid + 1, end);
        return root;
    }

    @Test
    public void test(){
        int[] arr={-10,-3,0,5,9};
        sortedArrayToBST(arr);
    }


}
