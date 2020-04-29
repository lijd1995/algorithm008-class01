package reversePrint;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static jdk.nashorn.internal.objects.NativeArray.reverse;

/**
 * 思路
 *
 * 1.改变指针的方向，O(n) O(1)
 * 2.递归改变整体 O(n) O(1)
 * 3.将结果入栈，最后出栈 O(n)O(n)
 */
public class reversePrint {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        node1.next = node2;
        reversePrint3(node1);
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    /*
    public static int[] reversePrint(ListNode head) {
        // head !=
        if (head == null) return  new int[0];
        ListNode node = null;
        int length = 0;
        while (head != null){
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
            length ++;
        }
        int[] nums = new int[length];
        int i=0;
        while (node != null){
            nums[i] = node.val;
            node = node.next;
            i++;
        }
        return nums;
    }
     */
    // 2.使用栈
    /*
    public int[] reversePrint1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i=0;i<res.length;i++)
            res[i] = stack.pop();
        return res;
    }
    */

    public static int[] reversePrint3(ListNode head) {
        List<Integer> list = new ArrayList<>();
        reverse(head,list);
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++)
            res[i] = list.get(i);
        return res;
    }

    static void reverse(ListNode head, List<Integer> list){
        if (head == null) return;
        reverse(head.next,list);
        list.add(head.val);
    }
}
