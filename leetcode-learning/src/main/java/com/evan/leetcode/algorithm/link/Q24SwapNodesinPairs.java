package com.evan.leetcode.algorithm.link;

import com.evan.leetcode.algorithm.link.classes.ListNode;
import com.evan.leetcode.algorithm.link.classes.TestHelper;
import org.junit.Test;

/**
 * Created by asus on 2018/1/24.
 */
public class Q24SwapNodesinPairs {

    //LEETCODE 4MS
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            cur.next = node2;
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
