package com.evan.interviews;


import com.evan.interviews.some_used_class.ListNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/13 9:44
 */
public class Q52_两个链表的第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1=pHead1,l2=pHead2;
        while (l1!=l2){
            l1=(l1==null)?pHead2:l1.next;
            l2=(l2==null)?pHead1:l2.next;
        }
        return l1;
    }








}
