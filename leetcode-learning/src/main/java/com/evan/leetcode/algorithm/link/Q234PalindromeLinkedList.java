package com.evan.leetcode.algorithm.link;

import com.evan.leetcode.LEETCODE.LINK.ListNode;

/**
 * Created by asus on 2018/1/25.
 */
public class Q234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null) {
            return true;
        }
        ListNode mid =getMid(head);
        ListNode right=reverse(mid.next);
        mid.next=null;
        while (right!=null&&head!=null&&right.val==head.val){
            right=right.next;
            head=head.next;
        }
        return right==null;
    }

    private ListNode reverse(ListNode cur) {
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;

        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre.next;
            pre.next=cur;
            cur=next;
        }
        return pre.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode fast=head.next,slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }

}
