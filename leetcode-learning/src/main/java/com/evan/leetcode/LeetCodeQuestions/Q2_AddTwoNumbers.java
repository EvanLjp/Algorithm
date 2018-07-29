package com.evan.leetcode.LeetCodeQuestions;

import LeetCodeQuestions.Classes.ListNode;

/**
 * @description: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * @author: evan
 * @create: 2018-05-24 21:57
 **/
public class Q2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode cur=head;
        int add=0;
        while (l1!=null||l2!=null){
            add+=(l1==null?0:l1.val)+(l2==null?0:l2.val);
            l1=(l1==null?l1:l1.next);
            l2=(l2==null?l2:l2.next);
            cur.next=new ListNode(add%10);
            add/=10;
            cur=cur.next;
        }
       if(add!=0)
           cur.next=new ListNode(add);
        return head.next;
    }


}
