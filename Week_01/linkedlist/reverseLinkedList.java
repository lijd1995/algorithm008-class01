package linkedlist;

import java.util.List;

/**
 * 反转链表
 *
 * 迭代法和递归
 */


public class reverseLinkedList {

    // 迭代法
    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        while(head != null){
            ListNode node = head;
            node.next = reverse;
            reverse = node;
            head = head.next;
        }
        return reverse;
    }

    // 递归法
}
