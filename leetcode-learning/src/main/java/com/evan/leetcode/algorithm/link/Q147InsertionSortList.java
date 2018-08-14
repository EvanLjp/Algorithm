package com.evan.leetcode.algorithm.link;

import com.evan.leetcode.algorithm.link.classes.ListNode;

/**
 * @author :evan
 * @date :2018-08-11 14:24
 **/
public class Q147InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = head;
        ListNode pre;
        while (cur != null) {
            pre = dummyHead;
            ListNode next = cur.next;
            while (pre.next != null && pre.next.val <= cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummyHead.next;
    }

}
