package com.evan.leetcode.algorithm.stack_queue;

import com.evan.leetcode.algorithm.link.classes.ListNode;

import java.awt.*;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author :evan
 * @date :2018-08-31 09:45
 **/
public class Q23MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode node : lists) {
            while (node != null) {
                queue.offer(node);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;

    }

    public ListNode mergeKLists_2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);


    }

    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next;
    }

}
