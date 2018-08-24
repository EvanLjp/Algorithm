package com.evan.coding;

import com.evan.interviews.some_used_class.RandomListNode;

/**
 * @author :evan
 * @date :2018-08-20 16:32
 **/
public class Q25复杂链表的复制 {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode temp = new RandomListNode(cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        cur = pHead;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        RandomListNode another = pHead.next;
        cur = pHead;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = cur.next.next;
            cur = next;
        }
        return another;

    }


}
