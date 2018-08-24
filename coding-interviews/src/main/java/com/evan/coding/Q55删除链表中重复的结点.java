package com.evan.coding;

import com.evan.interviews.some_used_class.ListNode;

/**
 * @author :evan
 * @date :2018-08-22 15:37
 **/
public class Q55删除链表中重复的结点 {

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode node = pHead.next;
        if ( node.val == pHead.val) {
            while (node!=null&&node.val == pHead.val) {
                node = node.next;
            }
            return deleteDuplication(node);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }


    }
}
