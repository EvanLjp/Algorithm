package com.evan.leetcode.LEETCODE.LINK;

import org.junit.Test;

/**
 * Created by asus on 2018/1/24.
 */
public class SwapNodesinPairs_24 {

    //LEETCODE 4MS
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }


    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = node1.next;
            node1.next = node2.next;
            cur.next = node2;
            node2.next = node1;
            cur = node1;
        }
        return dummyHead.next;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4};
        ListNode head = TestHelper.createLinkList(arr);
        TestHelper.PrintLinkList(head);
        ListNode head2 = swapPairs(head);
        TestHelper.PrintLinkList(head2);
    }


}
