package com.evan.leetcode.algorithm.stack_queue;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by asus on 2018/1/25.
 */
public class Q20ValidParentheses {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        storePair(map);
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (map.get(c).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private void storePair(Map<Character, Character> map) {
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
    }


    @Test
    public void test() {
        String s = "()";
        System.out.println(isValid(s));
    }

}
