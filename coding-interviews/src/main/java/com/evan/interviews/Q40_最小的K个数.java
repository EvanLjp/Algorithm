package com.evan.interviews;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 15:21
 */
public class Q40_最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length || k <= 0) return res;
        findKthSmallest(input, k - 1);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = paration(nums, l, h);
            if (j == k) break;
            else if (j > k) h = j - 1;
            else l = j + 1;
        }
    }

    private int paration(int[] nums, int l, int h) {
        //nums[l+1,i) nums(j,h]
        int i = l+1, j = h;
        while (true) {
            while (i <= h && nums[i] < nums[l]) i++;
            while (j >= l + 1 && nums[j] > nums[l]) j--;
            if (i >= j) break;
            swap(nums, i++, j--);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution_2(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        ArrayList<Integer> ret = new ArrayList<>(maxHeap);
        return ret;
    }
}
