package com.evan.leetcode.LEETCODE.SELECT;

import org.junit.Test;

import java.util.HashSet;

/**
 * Created by asus on 2018/1/7.
 */
public class WordPattern_290 {
    /*class Solution {
        public boolean wordPattern(String pattern, String str) {
            Map<String, String> patternMatch = new HashMap<>();
            String[] list = str.split(" ");
            if (list.length != pattern.length()) return false;

            for (int i = 0; i < pattern.length(); i++) {
                String key = pattern.substring(i, i+1);
                if (patternMatch.containsKey(key)) {
                    if (!patternMatch.get(key).equals(list[i])) {
                        return false;
                    }
                } else {
                    if (patternMatch.values().contains(list[i])) return false;
                    patternMatch.put(key, list[i]);
                }
            }
            return true;
        }
    }*/



    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] split = str.split(" ");
        HashSet a=new HashSet();
        HashSet b=new HashSet();
        for (int i = 0; i <chars.length ; i++) {
            a.add(chars[i]);
        }
        for (int i = 0; i <split.length ; i++) {
            b.add(split[i]);
        }
        if(chars.length!=split.length||a.size()!=b.size()) return false;
        String[] map=new String[256];
        for (int i = 0; i < chars.length; i++) {
            if(map[chars[i]]==null) {
                map[chars[i]]=split[i];
            }
            else if(!map[chars[i]].equals(split[i])) return false;
        }
        return true;
    }
    @Test
    public void test(){
        String[] map=new String[256];
        System.out.println(map[0]);
    }


}
