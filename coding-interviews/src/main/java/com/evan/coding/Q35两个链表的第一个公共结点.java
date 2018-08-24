package com.evan.coding;

import com.evan.interviews.some_used_class.ListNode;

/**
 * @author :evan
 * @date :2018-08-21 16:22
 **/
public class Q35两个链表的第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode a = pHead1, b = pHead2;
        while (a != b) {
            if (a == null) {
                a = pHead2;
                b = b.next;
            } else if (b == null) {
                b = pHead1;
                a = a.next;
            } else {
                a = a.next;
                b = b.next;
            }
        }
        return a;
    }


}
