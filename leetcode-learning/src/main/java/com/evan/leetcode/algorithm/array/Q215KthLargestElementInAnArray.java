package com.evan.leetcode.algorithm.array;

import com.evan.leetcode.algorithm.array.annotations.QuickSort;

/**
 * @author :evan
 * @date :2018-07-29 16:00
 **/
@QuickSort
public class Q215KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return findK(nums,nums.length-k , 0, nums.length - 1);
    }

    public int findK(int[] nums, int k, int i, int j) {
        if (i >= j) {
            return nums[i];
        }
        int m = partation(nums, i, j);
        if (m == k) {
            return nums[m];
        }
        else if (m < k) {
            return findK(nums, k, m + 1, j);
        } else {
            return findK(nums, k, i, m - 1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public int partation(int[] nums, int left, int right) {
        //[left,small],[small+1,large-1],[large,right]
        int mid = left+(right-left)/2;
        swap(nums,left,mid);
        int flag=nums[left];
        int i=left+1;
        int j=right;
        while (true){
            while (i<=right&&nums[i]<flag) {
                i++;
            }
            while (j>=left+1&&nums[j]>flag){
                j--;
            }
            if(i>j){
                break;
            }
            swap(nums,i,j);
            i++;
            j--;
        }
        swap(nums,left,j);
        return j;
    }
}
