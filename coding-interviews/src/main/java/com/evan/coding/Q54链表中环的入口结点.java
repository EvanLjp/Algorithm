package com.evan.coding;

import com.evan.interviews.some_used_class.ListNode;

/**
 * @author :evan
 * @date :2018-08-22 15:35
 **/
public class Q54链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow=pHead;
        ListNode fast=pHead;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=pHead;
                while (slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }

        }
        return null;


    }


}
