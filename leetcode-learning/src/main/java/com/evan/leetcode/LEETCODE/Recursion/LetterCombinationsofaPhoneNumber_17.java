package com.evan.leetcode.LEETCODE.Recursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2018/2/9.
 */
public class LetterCombinationsofaPhoneNumber_17 {

    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('0', " ");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new LinkedList<>();
        if (digits.equals("") || digits == null) return res;
        getRes(res, 0, digits.toCharArray(), "", map);
        return res;
    }

    private void getRes(List<String> res, int index, char[] chars, String string, Map<Character, String> map) {
        if (index == chars.length) {
            res.add(string);
            return;
        }
        String s = map.get(chars[index]);
        for (int i = 0; i < s.length(); i++) {
            getRes(res, index + 1, chars, string + s.charAt(i), map);
        }
    }


}
