package com.evan.leetcode.algorithm.link;

import com.evan.leetcode.algorithm.link.classes.ListNode;
import com.evan.leetcode.algorithm.link.classes.TestHelper;
import org.junit.Test;

/**
 * Created by asus on 2018/1/23.
 */
public class Q328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode left = odd;
        ListNode right = even;
        int count = 1;
        while (head != null) {
            if ((count & 1)==1) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            count++;
            head = head.next;
        }
        right.next = null;
        left.next = even.next;
        return odd.next;
    }
    @Test
    public void test(){
        int []arr={1,2,3,4,5};
        ListNode head = TestHelper.createLinkList(arr);
        TestHelper.PrintLinkList(head);
        ListNode head2 = oddEvenList(head);
        TestHelper.PrintLinkList(head2);

    }

}
