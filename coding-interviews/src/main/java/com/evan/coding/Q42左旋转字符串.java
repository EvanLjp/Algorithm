package com.evan.coding;


/**
 * @author :evan
 * @date :2018-08-21 19:45
 **/
public class Q42左旋转字符串 {
    public String LeftRotateString(String str, int n) {
        if (str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        n %= chars.length;
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);

    }

    private void reverse(char[] chars, int start, int right) {
        while (start < right) {
            swap(chars, start++, right--);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char c = chars[a];
        chars[a] = chars[b];
        chars[b] = c;
    }


}
