package LEETCODE.StackAndQueue;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by asus on 2018/1/25.
 */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char peek = stack.peek();
                if (isPair(peek, c)) stack.pop();
                else return false;
            }

        }
        if (stack.isEmpty()) return true;
        else return false;
    }

    private boolean isPair(char a, char b) {
        char pair;
        if (a == '(') pair = ')';
        else if (a == '[') pair = ']';
        else pair = '}';
        if (pair == b) return true;
        else return false;
    }

    @Test
    public void test() {
        String s = "{[()]}";
        System.out.println(isValid(s));
    }

}
