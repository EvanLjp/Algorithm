package LEETCODE.LINK;

/**
 * Created by asus on 2018/1/14.
 */
public class ReverseLinkedList_206 {

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre=null;
        while (head!=null){
           ListNode next=head.next;
           head.next=pre;
           pre=head;
           head=next;
        }
        return pre;
    }


}
