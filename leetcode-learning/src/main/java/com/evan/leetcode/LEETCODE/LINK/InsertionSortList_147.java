package com.evan.leetcode.LEETCODE.LINK;

import org.junit.Test;

/**
 * Created by asus on 2018/1/24.
 */
public class InsertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead=new ListNode(0);
        ListNode cur=head;
        ListNode pre;
        while (cur!=null){
            pre=dummyHead;
            ListNode next= cur.next;
            while (pre.next!=null&&pre.next.val<=cur.val){
                pre=pre.next;
            }
            cur.next=pre.next;
            pre.next=cur;
            cur=next;
        }
        return dummyHead.next;
    }

    @Test
    public void test(){
        int []arr={1,3,5,4,2};
        ListNode head = TestHelper.createLinkList(arr);
        TestHelper.PrintLinkList(head);
        head = insertionSortList(head);
        TestHelper.PrintLinkList(head);
    }



}
