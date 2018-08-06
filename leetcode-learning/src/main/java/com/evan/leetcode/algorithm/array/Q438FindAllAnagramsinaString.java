package com.evan.leetcode.algorithm.array;

import com.evan.leetcode.algorithm.array.annotations.SlidingWindow;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :evan
 * @date :2018-08-06 21:55
 **/
@SlidingWindow
public class Q438FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[256];
        for (char c : p.toCharArray()) {
            map[c]++;
        }
        //[left,right]
        int left = 0, right = 0;
        List<Integer> res = new ArrayList<>();
        int count = p.length();
        char[] chars = s.toCharArray();
        while (right<s.length()) {
            if (map[chars[right++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                if (map[chars[left++]]++ >= 0) {
                    count++;
                }

            }
        }
        return res;
    }

    @Test
    public void test(){
        String a="cbaebabacd";
        String b="abc";
        List<Integer> list = findAnagrams(a, b);
        System.out.println(list);
    }

}
