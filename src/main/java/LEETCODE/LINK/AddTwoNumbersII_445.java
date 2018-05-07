package LEETCODE.LINK;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by asus on 2018/1/23.
 */
public class AddTwoNumbersII_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2);
                l2 = l2.next;
            }

        }
        int sum = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        Stack<Integer> res = new Stack<>();
        while (!stack1.isEmpty() || !stack2.isEmpty() || sum != 0) {
            sum += stack1.isEmpty() ? 0 : stack1.pop().val;
            sum += stack2.isEmpty() ? 0 : stack2.pop().val;
            res.add(sum % 10);
            sum /= 10;
        }
        while (!res.isEmpty()){
            cur.next=new ListNode(res.pop());
            cur=cur.next;
        }
        return head.next;


    }

    @Test
    public void test() {
        int[] arr1 = {7, 2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = TestHelper.createLinkList(arr1);
        ListNode l2 = TestHelper.createLinkList(arr2);
        ListNode head = addTwoNumbers(l1, l2);
        TestHelper.PrintLinkList(head);
    }


}
