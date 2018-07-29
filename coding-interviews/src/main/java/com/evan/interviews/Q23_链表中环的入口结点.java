package com.evan.interviews;

import GetOffers.some_used_class.ListNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 13:57
 */
public class Q23_链表中环的入口结点 {
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
