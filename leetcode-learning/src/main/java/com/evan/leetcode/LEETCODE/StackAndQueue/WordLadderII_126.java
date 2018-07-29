package com.evan.leetcode.LEETCODE.StackAndQueue;

import org.junit.Test;

import java.util.*;

/**
 * Created by asus on 2018/2/3.
 */
public class WordLadderII_126 {
    static boolean flag = false;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        HashMap<String, Integer> depth = new HashMap<>();
        HashMap<String, List<String>> nexts = new HashMap<>();
        List<List<String>> res = new LinkedList<>();
        List<String> temp = new LinkedList<>();
        bfs(beginWord, endWord, depth, nexts, dict);
        dfs(beginWord, endWord, res, depth, nexts, temp);
        return res;
    }

    private void dfs(String cur, String endWord, List<List<String>> res, HashMap<String, Integer> depth, HashMap<String, List<String>> nexts, List<String> temp) {
        temp.add(cur);
        if (cur.equals(endWord)) {
            res.add(new ArrayList<>(temp));
            flag = true;
        } else {
            if (nexts.containsKey(cur)) {
                int size = res.size();
                for (String str :
                        nexts.get(cur)) {
                    if (depth.get(str) == depth.get(cur) + 1)
                        dfs(str, endWord, res, depth, nexts, temp);
                    if (flag) {
                        flag = false;
                        break;

                    }
                }
            }

        }
        temp.remove(temp.size() - 1);


    }

    private void bfs(String beginWord, String endWord, HashMap<String, Integer> depth, HashMap<String, List<String>> nexts, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(beginWord);
        int length = 1;
        depth.put(beginWord, 1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                getNexts(current, dict, nexts);
                for (String str : nexts.get(current)) {
                    if (depth.containsKey(str)) continue;
                    if (str.equals(endWord)) {
                        flag = true;
                    }
                    queue.add(str);
                    depth.put(str, length);
                }
            }
            if (flag) break;
        }
    }

    private void getNexts(String current, HashSet<String> dict, HashMap<String, List<String>> nexts) {
        int length = current.length();
        List<String> list = new ArrayList<>();
        char[] chars = current.toCharArray();
        for (int i = 0; i < length; i++) {
            char old = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == old) continue;
                chars[i] = j;
                String temp = String.valueOf(chars);
                if (dict.contains(temp)) {
                    list.add(temp);
                }
            }
            chars[i] = old;
        }

        nexts.put(current, list);
    }

    @Test
    public void test() {
        String[] arr = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> list = Arrays.asList(arr);
        System.out.println(findLadders("hit", "cog", list));
    }


}
