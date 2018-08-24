package com.evan.coding;

import com.evan.interviews.some_used_class.ListNode;

/**
 * @author :evan
 * @date :2018-08-20 11:08
 **/
public class Q16合并两个排序的链表 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummyHead.next;

    }


}
