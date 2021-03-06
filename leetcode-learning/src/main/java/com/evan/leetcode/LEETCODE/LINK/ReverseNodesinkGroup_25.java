package com.evan.leetcode.LEETCODE.LINK;

import org.junit.Test;

/**
 * Created by asus on 2018/1/24.
 */
public class ReverseNodesinkGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        int count = 0;
        while (head != null) {
            count++;
            ListNode next = head.next;
            if (count == k) {
                pre = reverse(pre, next);
                count = 0;
            }
            head = next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode pre, ListNode end) {
        if (pre == null || pre.next == null) return pre;
        ListNode head = pre.next;
        ListNode cur = pre.next.next;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        head.next = end;
        return head;
    }
    /*public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            count++;
            ListNode next = cur.next;
            if (count == k) {
                pre = reverse(pre, next);
                count = 0;
            }
            cur = next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode pre, ListNode end) {
        if (pre == null || pre.next == null)
            return pre;
        ListNode head = pre.next;
        ListNode cur = pre.next.next;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        head.next = end;
        return head;
    }*/

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = TestHelper.createLinkList(arr);
        TestHelper.PrintLinkList(head);
        ListNode head2 = reverseKGroup(head, 2);
        TestHelper.PrintLinkList(head2);

    }

}
