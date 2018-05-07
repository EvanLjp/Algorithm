package LEETCODE.ALL;

import LEETCODE.LINK.ListNode;
import LEETCODE.LINK.TestHelper;
import org.junit.Test;

/**
 * Created by asus on 2018/3/1.
 */
public class L2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carryBit = 0;
        int saveBirt = 0;
        while (l1 != null && l2 != null) {
            saveBirt = (l1.val + l2.val + carryBit) % 10;
            carryBit = (l1.val + l2.val + carryBit) / 10;
            cur.next = new ListNode(saveBirt);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            if (carryBit == 0) {
                cur.next = l1;
                break;
            }
            saveBirt = (l1.val + carryBit) % 10;
            carryBit = (l1.val + carryBit) / 10;
            cur.next = new ListNode(saveBirt);
            cur = cur.next;
            l1 = l1.next;

        }
        while (l2 != null) {
            if (carryBit == 0) {
                cur.next = l2;
                break;
            }
            saveBirt = (l2.val + carryBit) % 10;
            carryBit = (l2.val + carryBit) / 10;

            cur.next = new ListNode(saveBirt);
            cur = cur.next;
            l2 = l2.next;
        }
        if (carryBit != 0) cur.next = new ListNode(carryBit);
        return head.next;


    }

    @Test
    public void test() {
        ListNode a = TestHelper.createLinkList(new int[]{9, 8});
        ListNode b = TestHelper.createLinkList(new int[]{1});
        TestHelper.PrintLinkList(addTwoNumbers(a, b));

    }


}
