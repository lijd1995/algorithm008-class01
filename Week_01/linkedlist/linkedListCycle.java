package linkedlist; /**
 * 环形链表
 */

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1.哈希表
 * 2.快慢指针
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class linkedListCycle {
    // 1.哈希表
//    public boolean hasCycle(ListNode head) {
//        // 哈希表
//        Set<ListNode> nodeSet = new HashSet<>();
//        while(head != null){
//            if (nodeSet.contains(head)){
//                return true;
//            }else{
//                nodeSet.add(head);
//                head = head.next;
//            }
//        }
//        return false;
//    }

    // 2.快慢指针
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null || fast.next != null){
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
