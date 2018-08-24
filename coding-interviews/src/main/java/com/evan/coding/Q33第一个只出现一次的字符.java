package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-21 15:44
 **/
public class Q33第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        int[] map = new int[256];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            map[c]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]] == 1) {
                return i;
            }
        }
        return -1;


    }


}
