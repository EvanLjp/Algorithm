package com.leetcode;

import com.leetcode.annotations.category.Array;
import com.leetcode.annotations.thinking.DoublePointer;
import javax.xml.bind.ValidationEvent;
import org.junit.Test;

/**
 * @author : Evan.Liu
 * @date : 2020/8/23 23:39
 */
@DoublePointer
@Array
public class Q209_Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int s, int[] nums) {
        int leftIndex = 0;
        int rightIndex = 0;
        int minLength = nums.length + 1;
        int sum = 0;
        while (leftIndex < nums.length) {
            if (rightIndex < nums.length && sum < s) {
                sum += nums[rightIndex++];
            } else {
                sum -= nums[leftIndex++];
            }
            if (sum >= s) {
                minLength = minLength < rightIndex - leftIndex ? minLength : rightIndex - leftIndex;
            }
        }
        return minLength == nums.length + 1 ? 0 : minLength;
    }

    @Test
    public void test() {

        System.out.println(minSubArrayLen(7, new int[] {
            2,
            3,
            1,
            2,
            4,
            3
        }));
    }
}
