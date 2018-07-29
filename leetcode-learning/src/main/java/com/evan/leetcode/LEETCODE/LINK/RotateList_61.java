package com.evan.leetcode.LEETCODE.LINK;

/**
 * Created by asus on 2018/1/25.
 */
public class RotateList_61 {
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        int length = getLength(head);
        k = k % length;
        if(k==0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dummy2 = dummy;
        ListNode cur = dummy;
        for (int i = 0; i < k; i++) {
            dummy2 = dummy2.next;
        }
        while (dummy2.next != null) {
            cur = cur.next;
            dummy2 = dummy2.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        dummy2.next = dummy.next;
        return newHead;
    }


}
