package com.evan.leetcode.LEETCODE.LINK;

import org.junit.Test;

/**
 * Created by asus on 2018/1/24.
 */
public class RemoveDuplicatesfromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        dummyHead.next = head;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val != cur.next.next.val) {
                cur = cur.next;
            } else {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            }

        }
        return dummyHead.next;


    }

    @Test
    public void test() {
        int[] arr = {1, 1, 2, 3, 4, 4};
        ListNode head = TestHelper.createLinkList(arr);
        TestHelper.PrintLinkList(head);
        ListNode head2 = deleteDuplicates(head);
        TestHelper.PrintLinkList(head2);

    }

}
