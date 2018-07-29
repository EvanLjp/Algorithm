package com.evan.leetcode.LEETCODE.LINK;

/**
 * Created by asus on 2018/1/25.
 */
public class DeleteNodeinaLinkedList_237 {

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }


}
