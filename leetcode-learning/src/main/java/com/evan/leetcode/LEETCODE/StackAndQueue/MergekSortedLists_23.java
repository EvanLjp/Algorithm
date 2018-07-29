package com.evan.leetcode.LEETCODE.StackAndQueue;


import com.evan.leetcode.LEETCODE.LINK.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by asus on 2018/2/4.
 */
public class MergekSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            ListNode head=lists[i];
            while (head!=null){
                queue.offer(head);
                head=head.next;
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while (!queue.isEmpty()){
            cur.next=queue.poll();
            cur= cur.next;
        }
        cur.next=null;
        return dummy.next;
    }

}
