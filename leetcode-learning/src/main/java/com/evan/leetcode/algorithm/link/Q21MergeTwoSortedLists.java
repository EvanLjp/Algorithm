package com.evan.leetcode.algorithm.link;

import com.evan.leetcode.LEETCODE.LINK.ListNode;
import com.evan.leetcode.LEETCODE.LINK.TestHelper;
import org.junit.Test;

/**
 * Created by asus on 2018/1/24.
 */
public class Q21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return dummyHead.next;
    }

    @Test
    public void test() {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode l1 = TestHelper.createLinkList(arr1);
        ListNode l2 = TestHelper.createLinkList(arr2);
        ListNode head2 = mergeTwoLists(l1, l2);
        TestHelper.PrintLinkList(head2);
    }


}
