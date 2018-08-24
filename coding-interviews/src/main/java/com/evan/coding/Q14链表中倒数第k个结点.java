package com.evan.coding;

import com.evan.interviews.some_used_class.ListNode;

/**
 * @author :evan
 * @date :2018-08-20 10:57
 **/
public class Q14链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {

        ListNode cur = head;
        while (k > 0 && cur != null) {
            k--;
            cur = cur.next;
        }
        if (k > 0) {
            return null;
        }
        while (cur != null) {
            head = head.next;
            cur = cur.next;
        }
        return head;
    }


}
