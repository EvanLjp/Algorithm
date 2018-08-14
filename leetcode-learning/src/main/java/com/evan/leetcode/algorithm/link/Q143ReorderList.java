package com.evan.leetcode.algorithm.link;

import com.evan.leetcode.algorithm.link.classes.ListNode;

/**
 * @author :evan
 * @date :2018-08-14 11:21
 **/
public class Q143ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = getMid(head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        ListNode dummy = new ListNode(0), cur = dummy;
        while (head != null || right != null) {
            if (head != null) {
                cur.next = head;
                cur = cur.next;
                head = head.next;
            }
            if (right != null) {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }
        head = dummy.next;

    }

    private ListNode reverse(ListNode cur) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return pre.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
