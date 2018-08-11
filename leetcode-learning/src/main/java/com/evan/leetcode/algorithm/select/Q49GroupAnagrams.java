package com.evan.leetcode.algorithm.select;

import java.util.*;

/**
 * @author :evan
 * @date :2018-08-10 09:54
 **/
public class Q49GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newStr = String.valueOf(chars);
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
            }
            map.get(newStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 素数求解算法：
     * 使用26个素数分别表示26个小写字母，这样可以实现一个单词可以由多个素数的乘积表示，由于素数的特性，不同的单词计算出来的结果必不相同，从而一个单词可以由一个素数表示，
     * 在比对单词时，可极大减小运算量。
     * @param strs
     * @return
     */
    /*public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        Map<Integer, List<String>> map = new HashMap<>();
        for(String str:strs) {
            int k = 1;
            for(char ch:str.toCharArray()) {
                k *= primes[ch-'a'];
            }
            if(!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
            }
            map.get(k).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }*/
}
