package com.evan.leetcode.algorithm.link;

import com.evan.leetcode.algorithm.link.classes.ListNode;

/**
 * @author :evan
 * @date :2018-08-14 11:08
 **/
public class Q19RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead, q = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummyHead.next;
    }


}
