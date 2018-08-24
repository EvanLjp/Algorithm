package com.evan.coding;

import com.evan.interviews.some_used_class.ListNode;

import java.util.ArrayList;

/**
 * @author :evan
 * @date :2018-08-19 22:20
 **/
public class Q3从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        getRes(arrayList,listNode);
        return arrayList;
    }

    private void getRes(ArrayList<Integer> arrayList, ListNode listNode) {
        if (listNode==null){
            return;
        }
        getRes(arrayList,listNode.next);
        arrayList.add(listNode.val);
    }
}
