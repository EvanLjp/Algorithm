package com.evan.leetcode.LEETCODE.ARRAY;

/**
 * Created by asus on 2018/1/4.
 */
public class ReverseString_344 {
    public String reverseString(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        int rightIndex = chars.length - 1;
        while (leftIndex < rightIndex) {
            swap(chars, leftIndex++, rightIndex--);
        }
        return new String(chars);
    }

    private void swap(char[] arr, int l, int r) {
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
