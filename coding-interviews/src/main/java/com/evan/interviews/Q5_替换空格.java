package com.evan.interviews;

/**
 * Created by asus on 2018/3/21.
 */
public class Q5_替换空格 {
    public String replaceSpace(StringBuffer str) {
        int oldLen = str.length();
        for (int i = 0; i < oldLen; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int newLen = str.length() - 1;
        oldLen--;
        while (oldLen >= 0) {
            char c = str.charAt(oldLen--);
            if (c == ' ') {
                str.setCharAt(newLen--, '0');
                str.setCharAt(newLen--, '2');
                str.setCharAt(newLen--, '%');
            } else {
                str.setCharAt(newLen--, c);
            }
        }
        return str.toString();

    }


}
