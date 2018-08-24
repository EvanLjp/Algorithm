package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-22 15:17
 **/
public class Q52表示数值的字符串 {

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        String pattern = "[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?";
        return String.valueOf(str).matches(pattern);
    }
}
