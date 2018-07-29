package com.evan.interviews;

import GetOffers.some_used_class.ListNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 8:59
 */
public class Q18_1_在O1时间内删除链表节点 {

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if(head==null||tobeDelete==null) return head;

        if(tobeDelete.next!=null){
            tobeDelete.val=tobeDelete.next.val;
            tobeDelete.next=tobeDelete.next.next;
            return head;
        }else if(head==tobeDelete){
            return head.next;
        }else{
            ListNode cur=head;
            while (cur.next!=tobeDelete){
                cur=cur.next;
            }
            cur.next=null;
            return head;
        }
    }

}
