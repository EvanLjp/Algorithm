package com.evan.leetcode.LEETCODE.DynamicPrograming;


/**
 * Created by asus on 2018/2/19.
 */
public class PartitionEqualSubsetSum_416 {
    /**
     * 递归
     * time limit exceeded
     *
     * @param nums
     * @return
     */
    public boolean canPartition_1(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        return tryParation(nums, length - 1, sum / 2);
    }

    private boolean tryParation(int[] nums, int index, int capacity) {
        if (capacity == 0) return true;
        if (index < 0 || capacity < 0) return false;
        return tryParation(nums, index - 1, capacity) || tryParation(nums, index - 1, capacity - nums[index]);
    }

    /**
     * 52ms AC
     */
    int[][] map;

    public boolean canPartition_2(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int capacity = sum / 2;
        map = new int[length][capacity + 1];
        return tryParation_2(nums, length - 1, capacity) == 1;
    }

    private int tryParation_2(int[] nums, int index, int capacity) {
        if (capacity == 0) return 1;
        if (index < 0 || capacity < 0) return -1;
        if (map[index][capacity] == 0) {
            map[index][capacity] = (tryParation_2(nums, index - 1, capacity) == 1 || tryParation_2(nums, index - 1, capacity - nums[index]) == 1) ? 1 : -1;
        }
        return map[index][capacity];
    }

    /**
     * 动态规划
     *31ms
     * @param nums
     * @return
     */
    public boolean canPartition_3(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int capacity = sum / 2;
        boolean[] map = new boolean[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            if (i == nums[0]) {
                map[i] = true;
                break;
            }
        }
        for (int i = 1; i < length; i++) {
            for (int j = capacity; j >= nums[i]; j--) {
                map[j] = map[j] || map[j - nums[i]];
            }
        }
        return map[capacity];
    }


}
