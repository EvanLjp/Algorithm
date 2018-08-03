package com.evan.leetcode.algorithm.array;

import com.evan.leetcode.algorithm.array.annotations.CollisionPointer;

/**
 * @author jiapeng.liu
 * @date 2018/8/2 10:01
 **/
@CollisionPointer
public class Q344ReverseString {
    public String reverseString(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            swap(chars, left++, right--);


        }
        return new String(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char temp = chars[right];
        chars[right] = chars[left];
        chars[left] = temp;
    }


}
