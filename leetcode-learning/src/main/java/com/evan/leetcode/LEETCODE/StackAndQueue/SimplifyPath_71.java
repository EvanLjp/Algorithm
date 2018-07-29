package com.evan.leetcode.LEETCODE.StackAndQueue;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by asus on 2018/1/25.
 */
public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        String result = "/";
        String[] stubs = path.split("/+");
        ArrayList<String> paths = new ArrayList<String>();
        for (String s : stubs){
            if(s.equals("..")){
                if(paths.size() > 0){
                    paths.remove(paths.size() - 1);
                }
            }
            else if (!s.equals(".") && !s.equals("")){
                paths.add(s);
            }
        }
        for (String s : paths){
            result += s + "/";
        }
        if (result.length() > 1)
            result = result.substring(0, result.length() - 1);
        return result;
    }

    @Test
    public void test() {
        String s = "/...";
        System.out.println(simplifyPath(s));
    }

}
