package LEETCODE.LINK;

/**
 * Created by asus on 2018/1/25.
 */
public class RemoveNthNodeFromEndofList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode dummy2 = dummy;
        for (int i = 0; i < n + 1; i++) {
            dummy2 = dummy2.next;
        }
        while (dummy2 != null) {
            cur = cur.next;
            dummy2 = dummy2.next;
        }
        cur.next=cur.next.next;
        return dummy.next;
    }



}
