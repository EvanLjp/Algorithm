package com.evan.leetcode.algorithm.link;

import com.evan.leetcode.algorithm.link.classes.ListNode;

/**
 * @author :evan
 * @date :2018-08-11 08:57
 **/
public class Q206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}
