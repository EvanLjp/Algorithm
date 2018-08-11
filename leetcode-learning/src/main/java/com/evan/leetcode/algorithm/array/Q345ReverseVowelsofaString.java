package com.evan.leetcode.algorithm.array;

import com.evan.leetcode.algorithm.array.annotations.CollisionPointer;

/**
 * @author jiapeng.liu
 * @date 2018/8/2 13:13
 **/
@CollisionPointer
public class Q345ReverseVowelsofaString {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (!isYuanyin(chars[left])) {
                left++;
            } else if (!isYuanyin(chars[right])) {
                right--;
            } else {
                swap(chars, left++, right--);
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char temp = chars[right];
        chars[right] = chars[left];
        chars[left] = temp;
    }

    private boolean isYuanyin(char c) {
        return c == 'a' | c == 'e' | c == 'i' | c == 'o' | c == 'u' |
                c == 'A' | c == 'E' | c == 'I' | c == 'O' | c == 'U';
    }


}
