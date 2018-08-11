package com.evan.leetcode.algorithm.select;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :evan
 * @date :2018-08-09 22:08
 **/
public class Q205IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if (sChars.length != tChars.length) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < sChars.length; i++) {
            if (map.containsKey(sChars[i])) {
                if (map.get(sChars[i]).equals(tChars[i])) {
                    continue;
                } else {
                    return false;
                }

            }
            if (map.containsValue(tChars[i])) {
                return false;
            }
            map.put(sChars[i], tChars[i]);
        }

        return true;
    }


}
