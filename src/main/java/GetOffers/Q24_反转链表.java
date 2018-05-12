package GetOffers;

import GetOffers.some_used_class.ListNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 16:29
 */
public class Q24_反转链表 {
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre = head.next;
        head.next=null;
        ListNode newHead = ReverseList(pre);
        pre.next=head;
        return newHead;
    }

    public ListNode ReverseList_2(ListNode head) {
        ListNode newHead=new ListNode(-1);
        ListNode next;
        while (head!=null){
            next=head.next;
            head.next=newHead.next;
            newHead.next=head;
            head=next;
        }
        return newHead.next;

    }













}
