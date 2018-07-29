package com.evan.interviews;


import com.evan.interviews.some_used_class.ListNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 13:31
 */
public class Q22_链表中倒数第K个结点 {


    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode curHead=head,curTail=head;
        while (curTail!=null&&k-->0){
            curTail=curTail.next;
        }
        if(k>0) return null;
        while (curTail!=null){
            curTail=curTail.next;
            curHead=curHead.next;
        }
        return curHead;
    }
}
