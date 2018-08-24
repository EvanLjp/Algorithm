package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-21 20:06
 **/
public class Q43翻转单词顺序列 {
    public String ReverseSentence(String str) {
        String[] strings = str.split(" ");
        if (strings.length == 0) {
            return str;
        }
        int left = 0, right = strings.length - 1;
        while (left < right) {
            swap(strings, left++, right--);
        }
        String res = "";
        for (int i = 0; i < strings.length; i++) {
            res += strings[i];
            if (i != strings.length - 1) {
                res += " ";
            }
        }
        return res;
    }

    private void swap(String[] strings, int a, int b) {
        String temp = strings[a];
        strings[a] = strings[b];
        strings[b] = temp;
    }

}
