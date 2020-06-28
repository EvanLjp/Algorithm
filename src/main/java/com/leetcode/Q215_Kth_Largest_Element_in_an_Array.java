package com.leetcode;

import com.leetcode.annotations.category.Array;
import com.leetcode.annotations.thinking.CollisionPointer;
import com.leetcode.annotations.thinking.QuickSort;
import org.junit.Test;

/**
 * @author : Evan.Liu
 * @date : 2020/6/27 14:46
 */
@Array
@QuickSort
@CollisionPointer
public class Q215_Kth_Largest_Element_in_an_Array {

    public int findKthLargest(int[] nums, int k) {
        return findK(nums, nums.length - k, 0, nums.length - 1);
    }

    private int findK(final int[] nums, final int pos, final int i, final int j) {
        if (i >= j) {
            return nums[i];
        }
        int m = partition(nums, i, j);
        if (m == pos) {
            return nums[m];
        } else if (m < pos) {
            return findK(nums, pos, m + 1, j);
        } else {
            return findK(nums, pos, i, m - 1);
        }

    }

    private int partition(final int[] nums, final int left, final int right) {
        int randomPos = (int) (Math.random() * (right - left + 1) + left);
        swap(nums, left, randomPos);
        int flag = nums[left];
        int begin = left + 1, end = right;
        while (true) {
            while (begin <= right && nums[begin] <= flag) {
                begin++;
            }
            while (end > left && nums[end] >= flag) {
                end--;
            }
            if (begin >= end) {
                break;
            }
            swap(nums, begin, end);
        }
        swap(nums, left, end);
        return end;

    }

    private void swap(final int[] nums, final int i, final int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int kthLargest = findKthLargest(new int[] {
            3,
            2,
            1,
            5,
            6,
            4
        }, 2);
        System.out.println(kthLargest);
    }
}
