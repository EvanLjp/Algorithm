package com.evan.leetcode.algorithm.link;

import com.evan.leetcode.LEETCODE.LINK.ListNode;

/**
 * Created by asus on 2018/1/25.
 */
public class Q237DeleteNodeinaLinkedList {

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }


}
