package com.evan.leetcode.algorithm.array;

import com.evan.leetcode.algorithm.array.annotations.SlidingWindow;

/**
 * @author :evan
 * @date :2018-08-06 23:02
 **/
@SlidingWindow
public class Q76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int [] map=new int[256];
        for (char c:t.toCharArray()){
            map[c]++;
        }
        int count = t.length();
        int left=0,right=0;
        char[] chars = s.toCharArray();
        String res="";
        int minLen=Integer.MAX_VALUE;
        while (right<s.length()){
            if (map[chars[right++]]-->0){
                count--;
            }
            while (count==0){
                if(map[chars[left++]]++==0) {
                    int  min=right-left-1;
                    if(min<minLen){
                        minLen=min;
                        res=s.substring(left-1,right);
                    }
                    count++;
                }
            }
        }
        return res;
    }


}
