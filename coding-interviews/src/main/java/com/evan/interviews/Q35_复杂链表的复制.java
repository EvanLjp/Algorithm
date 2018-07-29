package com.evan.interviews;

import GetOffers.some_used_class.RandomListNode;

import java.util.HashMap;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 10:15
 */
public class Q35_复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null) return null;
        RandomListNode newhead=new RandomListNode(-1);
        RandomListNode cur=pHead;
        RandomListNode curAnother=newhead;
        HashMap<RandomListNode,RandomListNode> map=new HashMap<>();
        while (cur!=null){
            RandomListNode newOne=new RandomListNode(cur.label);
            curAnother.next=newOne;
            map.put(cur,newOne);
            cur=cur.next;
            curAnother=curAnother.next;
        }
        cur=pHead;
        curAnother=newhead.next;
        while (cur!=null){
            curAnother.random=map.get(cur.random);
            cur=cur.next;
            curAnother=curAnother.next;
        }
        return newhead.next;
    }

    public RandomListNode Clone_2(RandomListNode pHead) {
        if(pHead==null) return null;
        RandomListNode cur=pHead;
        //插入
        while (cur!=null){
            RandomListNode newOne=new RandomListNode(cur.label);
            newOne.next=cur.next;
            cur.next=newOne;
            cur=cur.next.next;
        }
        cur=pHead;
        //设置随机节点
        while (cur!=null){
            if (cur.random != null)
            cur.next.random=cur.random.next;
            cur=cur.next.next;
        }
        cur= pHead;
        RandomListNode pCloneHead=pHead.next;
        //拆分
        while (cur.next!=null){
            RandomListNode next=cur.next;
            cur.next=cur.next.next;
            cur=next;
        }
        return pCloneHead;


    }
}
