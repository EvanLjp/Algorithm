package com.evan.leetcode.algorithm.link;

import com.evan.leetcode.algorithm.link.classes.ListNode;

/**
 * @author :evan
 * @date :2018-08-11 10:33
 **/
public class Q83RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode flag = head, cur = head;

        while (cur != null) {
            if (flag.val != cur.val) {
                flag.next = cur;
                flag = cur;
            } else if (cur.next == null) {
                flag.next = null;
            }
            cur = cur.next;
        }
        return head;
    }
}
