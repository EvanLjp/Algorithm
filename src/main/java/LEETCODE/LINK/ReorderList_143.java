package LEETCODE.LINK;

import org.junit.Test;

/**
 * Created by asus on 2018/1/25.
 */
public class ReorderList_143 {
    public ListNode reorderList(ListNode head) {
        if (head==null||head.next==null) return null;
        ListNode mid=getMid(head);
        ListNode right=reverse(mid.next);
        mid.next=null;
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        for (int i = 0; head!=null||right!=null; i++) {
            if(head!=null){
                cur.next=head;
                cur=cur.next;
                head=head.next;
            }
            if(right!=null){
                cur.next=right;
                cur=cur.next;
                right=right.next;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode cur) {
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;

        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre.next;
            pre.next=cur;
            cur=next;
        }
        return pre.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode fast=head.next,slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }

    @Test
    public void test(){
        int[] arr={1,2,3,4,5};
        ListNode head = TestHelper.createLinkList(arr);
        ListNode node = reorderList(head);
        TestHelper.PrintLinkList(node);
    }


}
