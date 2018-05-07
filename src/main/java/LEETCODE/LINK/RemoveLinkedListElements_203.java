package LEETCODE.LINK;

import org.junit.Test;

/**
 * Created by asus on 2018/1/24.
 */
public class RemoveLinkedListElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode cur=dummyHead;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return dummyHead.next;
    }

    @Test
    public void test(){
        int[] arr={1,2,3,4,5,6};
        ListNode head = TestHelper.createLinkList(arr);
        TestHelper.PrintLinkList(head);
        ListNode head2 = removeElements(head, 6);
        TestHelper.PrintLinkList(head2);
    }




}
