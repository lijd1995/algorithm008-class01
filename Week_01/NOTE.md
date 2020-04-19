# 数组和链表

## 前言

<br />本周主要学习了数组和链表的课程，队列和栈的课程因为个人的原因没有学习，下周会补上。下面主要分三块，分别是知识总结，算法总结和个人反思。<br />

## 知识总结

### 数组

<br />数组是内存开辟的一段连续内存空间，因为连续内存空间和相同类型的数据这两个条件，可以让它满足“随机访问”。<br />
<br />那因为空间必须是连续的，所以在进行添加和删除操作必须要对空间进行挪动，而且开辟的内存空间大小是固定的，如果超出数组的大小，就会报出数组越界的异常。那 ArrayList 是如何扩容的？ArrayList 也是新开辟一个数组，然后把旧的数组内容复制到新的数组上，只是 ArrayList 这种容器帮助我们减少了对数组的操作，我们只需要注重方法，具体的会在 ArrayLisy 中内部实现。<br />
<br />**这里提出两个小问题**

- 为什么访问数组索引是从 0 开始而不是从 1 开始的？


<br />数组的索引其实是 offset 的意思，是位移量。内存中开辟内存空间不是从 0 开始的，是有一定的需要，比如 int[] a = new int[8]，开辟 8 个连续的内存空间，可能会从 1000 开始到 1031，那 int[0] 的值就是从 1000 开始计算，挪动  4 位(根据不同的操作引擎位数会不一样)，那获取值的开始位置，计算公式就是 1000 + 4*i。所以 int 的下标其实是偏移量的意思。<br />

- 如何让删除的时间复杂度降低呢？


<br />减少删除的操作，记录下来，一次性多删除几个，可以减少数组的移动造成的时间占用。<br />
<br />应用：JVM 标记清除垃圾回收算法。
### 链表

<br />链表分为：单链表、双向链表和循环链表。<br />
<br />其实这三者的区别就是前后指针的指向关系：

- 单链表，尾节点 next 指向 null
- 双向链表，包含 prev 指针，指向前节点
- 循环链表，尾节点 next 指向头节点**


<br />**应用**：LRU 缓存（Least Recently Used） 最近最少使用算法<br />

<a name="fTzEF"></a>
#### 数组和链表的比较


- 容量


<br />数组：大小固定<br />链表：动态扩容<br />

- 时间复杂度



|  | ArrayList | LinkedList |
| --- | --- | --- |
| prepend | O(n) | O(1) |
| append | O(1) | O(1) |
| lookup | O(1) | O(n) |
| insert | O(n) | O(1) |
| delete | O(n) | O(1) |

### 跳表

<br />如何可以让链表的查询也可以更高效呢？就用到了跳表。跳表的时间复杂度是 O(logN)。但使用前提的条件是这个链表的顺序的结构才可以使用。<br />
<br />方法就是通过增加索引来加快查找的速度，具体的就不详细描述了，<br />
<br />我们只需要了解其中的思想

- 加快查询速度：从一维变到二维
- 空间换时间的思想（具体问题具体分析，不能盲目空间换时间）



## 算法总结


对于数组的联系还是很多的，链表周日才开始练习，写起来还是很吃力的。我把这些算法中大致的思路总结一下。<br />

### 快慢指针

<br />**思路：**定义两个指针，第一个指针作为比较对象，第二个指针进行遍历和第一个指针的内容进行比较，满足一定的条件后，进行交换等操作，然后第一个指针往后移动。<br />
<br />**LeetCode**：<br />

- [https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
- [https://leetcode-cn.com/problems/move-zeroes/](https://leetcode-cn.com/problems/move-zeroes/)


<br />
### 前后指针

<br />**思路**：一般是比较大小的时候会用到，一前一后，两个进行操作或者比较。当某些条件下，前面指针向后移动或者后面指针向前移动，从而达到某个效果。<br />
<br />**leetCode**：<br />

- [https://leetcode-cn.com/problems/container-with-most-water/](https://leetcode-cn.com/problems/container-with-most-water/)
- [https://leetcode-cn.com/problems/3sum/](https://leetcode-cn.com/problems/3sum/)



<a name="SgDNT"></a>
### 递归

<br />**思路：**有一定的规律，当递归达到某种条件是继续递归，还是返回值，这一块需要清晰。但递归的时间复杂度还是很高，因为会一直往里循环操作。要慎用。<br />**<br />**leetCode：**<br />**

- [https://leetcode.com/problems/reverse-linked-list/](https://leetcode.com/problems/reverse-linked-list/)
- [https://leetcode.com/problems/linked-list-cycle](https://leetcode.com/problems/linked-list-cycle)

<br />

## 个人总结

<br />重新学习算法，用五毒神掌进行学习，感觉效果好了很多。让自己对学习算法更加的自信，并且通过过遍数要把东西变成自己的。<br />
<br />反思下自己，链表的基础很薄弱，算法刷的遍数还是少，有的题今天重做还是没有记住。还有没有学习栈和队列相关的知识。下周要更加努力的跟上进度，并且把题目好好的总结，汇总。也不要注重数量，不注重质量。<br />
<br />加油！

