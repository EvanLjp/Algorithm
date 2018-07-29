package com.evan.leetcode.LEETCODE.LINK;

import org.junit.Test;

/**
 * Created by asus on 2018/1/15.
 */
public class RemoveDuplicatesfromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curNode = head;
        ListNode tag = head;
        while (curNode != null) {
            if (tag.val != curNode.val) {
                tag.next = curNode;
                tag = curNode;
            }else if(tag.val==curNode.val&&curNode.next==null){
                tag.next=null;
            }
            curNode = curNode.next;
        }

        return head;
    }

    @Test
    public void test(){
        int []arr={1,1};
        ListNode head = TestHelper.createLinkList(arr);
        TestHelper.PrintLinkList(head);
        ListNode head2 = deleteDuplicates(head);
        TestHelper.PrintLinkList(head2);

    }
}
