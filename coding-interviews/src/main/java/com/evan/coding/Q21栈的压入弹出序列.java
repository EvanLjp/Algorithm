package com.evan.coding;

import java.util.Stack;

/**
 * @author :evan
 * @date :2018-08-20 14:42
 **/
public class Q21栈的压入弹出序列 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int n = pushA.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while (!stack.isEmpty()&&stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

}
