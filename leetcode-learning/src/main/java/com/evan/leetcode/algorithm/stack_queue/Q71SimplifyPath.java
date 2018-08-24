package com.evan.leetcode.algorithm.stack_queue;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by asus on 2018/1/25.
 */
public class Q71SimplifyPath {
    public String simplifyPath(String path) {
        String result = "";
        String[] strings = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (String s : strings) {
            if (s.equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }
        for (String s : stack) {
            result += "/" + s;
        }
        return result.equals("") ? "/" : result;
    }

    @Test
    public void test() {
        String s = "/a/./b/../../c/";
        System.out.println(simplifyPath(s));
    }

}
