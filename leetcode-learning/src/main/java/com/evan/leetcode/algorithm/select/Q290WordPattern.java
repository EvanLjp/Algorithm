package com.evan.leetcode.algorithm.select;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :evan
 * @date :2018-08-09 21:49
 **/
public class Q290WordPattern {
    public boolean wordPattern(String pattern, String str) {

        char[] patterns = pattern.toCharArray();
        String[] words = str.split(" ");
        if (patterns.length != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < patterns.length; i++) {
            if (map.containsKey(patterns[i])) {
                if (!map.get(patterns[i]).equals(words[i])) {
                    return false;
                }

                continue;
            }

            if (map.containsValue(words[i])) {
                return false;
            }

            map.put(patterns[i], words[i]);
        }

        return true;

    }


}
