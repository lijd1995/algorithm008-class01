- 链表反转
```java
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
```
- 递归
```java
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
```
- 栈
```java
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
```