package com.evan.interviews;

import GetOffers.some_used_class.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by asus on 2018/3/21.
 */
public class Q6_从尾到头打印链表 {
    /**
     * 方法1:改变链表,构建逆序
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null) return arrayList;
        ListNode pre = null;
        ListNode cur = listNode;
        ListNode next = cur.next;
        while (cur.next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        while (cur != null) {
            arrayList.add(cur.val);
            cur = cur.next;
        }
        return arrayList;
    }

    /**
     * 使用栈的特性进行操作
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * 使用递归
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead_3(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode != null) {
            arrayList.addAll(printListFromTailToHead_3(listNode.next));
            arrayList.add(listNode.val);
        }
        return arrayList;
    }


    @Test
    public void test() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;
        System.out.println(printListFromTailToHead(a1));

    }

}


