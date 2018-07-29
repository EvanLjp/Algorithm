package com.evan.leetcode.LEETCODE.LINK;

import org.junit.Test;

/**
 * Created by asus on 2018/1/14.
 */
public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode org = head;
        if (head == null) return head;
        int count = 1;
        ListNode pre = null;
        while (count < m) {
            pre = head;
            head = head.next;
            count++;
        }
        ListNode PRE = pre;
        pre = null;
        while (count < n + 1) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count++;
        }
        if (PRE == null) {
            org = pre;
        } else {
            PRE.next = pre;
        }
        ListNode LAST = head;
        head = org;
        while (head.next != null) {
            head = head.next;
        }
        head.next = LAST;
        return org;
    }

    @Test
    public void test() {
        int[]arr={1,2,3,4,5};
        ListNode head = TestHelper.createLinkList(arr);
        TestHelper.PrintLinkList(head);
        ListNode head2 = reverseBetween(head, 2, 4);
        TestHelper.PrintLinkList(head2);
    }
}
