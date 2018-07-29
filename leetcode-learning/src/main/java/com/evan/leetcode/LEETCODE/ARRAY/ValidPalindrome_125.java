package com.evan.leetcode.LEETCODE.ARRAY;

/**
 * Created by asus on 2018/1/4.
 */
public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s == null || s.length() == 0) return true;
        char[] res = s.toCharArray();
        int leftIndex = 0;
        int rightIndex = res.length - 1;
        while (leftIndex < rightIndex) {
            if (!isValid(res[leftIndex])) leftIndex++;
            else if (!isValid(res[rightIndex])) rightIndex--;
            else if (res[leftIndex] == res[rightIndex]) {
                leftIndex++;
                rightIndex--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    public static void main(String[] args) {
        String ss = "kjasfdljQQQQ";
        System.out.println(ss);
        ss.toLowerCase();
        System.out.println(ss);
    }

}
