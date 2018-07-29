package com.evan.leetcode.LeetCodeQuestions.Classes;

/**
 * @description: Given a string, find the length of the longest substring without repeating characters.
 * @author: evan
 * @create: 2018-05-24 22:20
 **/
public class Q3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int [] arr=new int[256];
        char[] chars = s.toCharArray();
        int res=0;
        for (char c:chars){
            if(arr[c]!=0)
                continue;
            arr[c]++;
            res++;
        }
        return res;
    }

}
