package com.evan.leetcode.algorithm.array;

import com.evan.leetcode.algorithm.array.annotations.CollisionPointer;

/**
 * @author jiapeng.liu
 * @date 2018/8/2 13:26
 **/
@CollisionPointer
public class Q11ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;

        int left = 0, right = height.length - 1;
        while (left < right) {
            int minIndex = height[left] > height[right] ? right : left;
            max = Math.max(max, (right - left) * height[minIndex]);
            if (minIndex == left) {
                while (left < right && height[minIndex] >= height[left]) {
                    left++;
                }
            } else {
                while (left < right && height[minIndex] >= height[right]) {
                    right--;
                }
            }
        }
        return max;
    }


}
