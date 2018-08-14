package com.evan.leetcode.algorithm.link;

import com.evan.leetcode.algorithm.link.classes.ListNode;

/**
 * @author :evan
 * @date :2018-08-11 09:27
 **/
public class Q92ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode pre = null, cur = head;
        while (cur != null && count < m) {
            pre = cur;
            cur = cur.next;
            count++;
        }
        ListNode preNode = pre;
        ListNode nextNode = cur;
        pre = null;
        while (cur != null && count < n + 1) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            count++;
        }
        if (preNode == null) {
            head = pre;
        } else {
            preNode.next = pre;
        }
        nextNode.next = cur;
        return head;

    }

}
