package LEETCODE.StackAndQueue;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by asus on 2018/1/25.
 */
public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (String temp: tokens) {
            if(!"+-*/".contains(temp)){
                stack.push(Integer.parseInt(temp));
            }else {
                int number2 =stack.pop();
                int number1 =stack.pop();
                switch (temp){
                    case "+":stack.push(number1+number2);break;
                    case "-":stack.push(number1-number2);break;
                    case "*":stack.push(number1*number2);break;
                    case "/":stack.push(number1/number2);break;
                }
            }

        }
        return stack.peek();
    }

    @Test
    public void test(){
        String[] ss={"2","1","+","3","*"};
        System.out.println(evalRPN(ss));
    }



}
