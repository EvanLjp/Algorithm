package com.evan.leetcode.LEETCODE.LINK;

import org.junit.Test;

/**
 * Created by asus on 2018/1/23.
 */
public class AddTwoNumbers_2 {




    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0;
        ListNode res=new ListNode(0);
        ListNode cur=res;
        for(ListNode i = l1, j = l2; i!=null||j!=null||sum!=0;){
            sum+=i!=null?i.val:0;
            sum+=j!=null?j.val:0;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            sum/=10;
            if(i!=null) i=i.next;
            if(j!=null) j=j.next;
        }
        return res.next;
    }

    @Test
    public void test(){
        int[] arr1={9};
        /*int[] arr2={1,9,9,9,9,9,9,9,9,9};*/
        int[] arr2={1,9};
        ListNode l1 = TestHelper.createLinkList(arr1);
        ListNode l2 = TestHelper.createLinkList(arr2);
        ListNode head = addTwoNumbers(l1, l2);
        TestHelper.PrintLinkList(head);


    }

}
