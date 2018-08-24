package com.evan.coding;

import java.lang.reflect.Modifier;
import java.util.Stack;

/**
 * @author :evan
 * @date :2018-08-20 14:37
 **/
public class Q20包含min函数的栈 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (min.isEmpty()||node < min.peek()) {
            min.push(node);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }


}
