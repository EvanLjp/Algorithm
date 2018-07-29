package com.evan.leetcode.LEETCODE.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/10.
 */
public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        getRes(s, 0, new LinkedList<>(), res);
        return res;
    }

    private void getRes(String s, int startIndex, List<String> partation, List<List<String>> res) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(partation));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String before = s.substring(startIndex, i + 1);
            if (!isPalindrome(before)) continue;
            partation.add(before);
            getRes(s, i + 1, partation, res);
            partation.remove(partation.size() - 1);
        }
    }

    private boolean isPalindrome(String string) {
        for (int i = 0, j = string.length() - 1; i < j; i++, j--) {
            if (string.charAt(i) != string.charAt(j)) return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(partition("aab"));
    }

}
