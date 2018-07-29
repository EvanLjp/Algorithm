package com.evan.leetcode.LEETCODE.LINK;


/**
 * Created by asus on 2018/1/15.
 */
public class TestHelper {

    public static ListNode createLinkList(int[] arr) {
        if (arr == null) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void PrintLinkList(ListNode head) {
        ListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.val + "--->");
            curNode = curNode.next;
        }
        System.out.println("NULL");
    }


}
