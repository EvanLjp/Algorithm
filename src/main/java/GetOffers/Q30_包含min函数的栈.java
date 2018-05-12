package GetOffers;

import java.util.Stack;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 21:49
 */
public class Q30_包含min函数的栈 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        min.push(min.size() == 0 || node < min.peek() ? node : min.peek());
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
