package com.evan.leetcode.algorithm.select;

import java.lang.ref.Reference;

/**
 * @author :evan
 * @date :2018-08-09 21:01
 **/
public class Q242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[256];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }

        for (char c : t.toCharArray()) {
            if (arr[c] == 0) {
                return false;
            }
            arr[c]--;

        }
        return true;
    }

}
