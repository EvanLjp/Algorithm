package com.evan.coding;

import org.junit.Test;

/**
 * @author :evan
 * @date :2018-08-19 22:09
 **/
public class Q2替换空格 {
    public String replaceSpace(StringBuffer str) {
        int oldLength = str.length();
        for (int i = 0; i < oldLength; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int newLength = str.length() - 1;
        for (int i = oldLength - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(newLength--, '0');
                str.setCharAt(newLength--, '2');
                str.setCharAt(newLength--, '%');
            } else {
                str.setCharAt(newLength--, str.charAt(i));
            }
        }
        return str.toString();
    }
    @Test
    public void test(){

        System.out.println(replaceSpace(new StringBuffer("hello world")));
    }



}
