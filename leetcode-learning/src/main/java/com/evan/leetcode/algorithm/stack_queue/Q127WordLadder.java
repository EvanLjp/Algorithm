package com.evan.leetcode.algorithm.stack_queue;

import org.junit.Test;

import java.util.*;

/**
 * @author :evan
 * @date :2018-08-16 11:14
 **/
public class Q127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        HashSet<String> from = new HashSet<>();
        HashSet<String> to = new HashSet<>();
        from.add(beginWord);
        to.add(endWord);
        dict.remove(endWord);
        return BFS(from, to, dict, 2);
    }

    private int BFS(Set<String> from, Set<String> to, Set<String> dict, int len) {
        if (from.isEmpty() || to.isEmpty()) {
            return 0;
        }
        if (from.size() > to.size()) {
            return BFS(to, from, dict, len);
        }
        Set<String> temp = new HashSet<>();
        for (String word : from) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                for (char j = 'a'; j < 'z'; j++) {
                    if (c == j) {
                        continue;
                    }
                    chars[i] = j;
                    String value = String.valueOf(chars);
                    if (to.contains(value)) {
                        return len;
                    }
                    if (dict.contains(value)) {
                        dict.remove(value);
                        temp.add(value);
                    }
                }
                chars[i] = c;
            }
        }
        return BFS(temp, to, dict, len + 1);


    }

    @Test
    public void test() {
        String[] arr = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> list = Arrays.asList(arr);
        System.out.println(ladderLength("hit", "cog", list));
    }
}
