package com.evan.interviews;


import com.evan.interviews.some_used_class.ListNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 9:38
 */
public class Q18_2删除链表中重复的结点 {

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode nextOne=pHead.next;
        if(nextOne.val==pHead.val){
            while (nextOne!=null&&nextOne.val==pHead.val){
                nextOne=nextOne.next;
            }
            return deleteDuplication(nextOne);
        }else {
             pHead.next=deleteDuplication(pHead.next);
             return pHead;
        }
    }
}
