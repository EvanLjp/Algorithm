package GetOffers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 22:07
 */
public class Q31_栈的压入弹出序列 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Queue<Integer> queue=new LinkedList<>();
        for (int a:popA){
            queue.add(a);
        }
        Stack<Integer> stack=new Stack<>();
        for (int a:pushA){
            stack.push(a);
            while (!stack.isEmpty()&&!queue.isEmpty()&&stack.peek()==queue.peek()){
                stack.pop();
                queue.poll();
            }
        }
        return stack.isEmpty()&&queue.isEmpty();


    }


}
