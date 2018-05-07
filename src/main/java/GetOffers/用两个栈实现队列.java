package GetOffers;

import java.util.Stack;

/**
 * Created by asus on 2018/3/21.
 */
public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (stack2.size()!=0){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (stack1.size()!=0){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

}
