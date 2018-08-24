package com.evan.interviews;

import java.util.Stack;

/**
 * Created by asus on 2018/3/21.
 */
public class Q9_用两个栈实现队列 {
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (out.isEmpty()) {
            throw new Exception("queue is empty");
        }

        return out.pop();

    }

}
