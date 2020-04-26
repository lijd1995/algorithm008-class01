# 堆 Heap

Heap:可以迅速找到一堆数的**最大****或者**最小**值的数据结构**。

将根节点最大的堆叫做最大顶堆或大根堆，根节点最小的堆叫做小顶堆或小根堆。

常见的堆有**二叉堆**、**斐波那契堆**等。

假设是大顶堆，则常见操作（API）：

- find-max：O(1)
- delete-max：O(logN)
- insert(create)：O(logN) or O(1)

Heap 是一个接口，有很多堆都实现了该接口，并且效率比二叉堆更好。

## 二叉堆性质

二叉堆本身实现相对容易，但是的话它的时间复杂度就是在**刚刚及格**里面。

通过完全二叉树来实现的，什么是完全二叉树，是根和每一个结点都是满的（注意：不是二叉搜索树），堆和二叉搜索树也没有那种关系。

虽然二叉搜索树也能实现堆，但是 find-min 是 O(logn)，不是 O1(1)。

二叉堆（大顶堆）它满足下列性质：

- 是一颗完全树
- 树中任意节点的值总是 >= 其子节点的值；

下图就是一个二叉堆

![](https://user-gold-cdn.xitu.io/2020/4/26/171b6e3341fdf82f?w=705&h=422&f=png&s=60281)

我们可以看到二叉堆的根节点就是最大的结点。

## 二叉堆实现细节

1. 二叉堆一般都通过「数组」来实现
2. 假设「第一个元素」在数组中的索引为 0 的话，则父节点和子节点的位置关系如下：
   1. 根节点（顶堆元素）：a[0]
   2. 索引为 i 的左孩子的索引是(2*i+1)
   3. 索引为 i 的右孩子的索引是(2*i+2)
   4. 索引为 i 的父结点的索引是 floor((i-1)/2)

![](https://user-gold-cdn.xitu.io/2020/4/26/171b6ebf176866bb?w=727&h=500&f=png&s=140802)

## Insert 插入操作

**时间复杂度**：O(logN)

HeapifyUp

1. 新元素一律先插入到堆的尾部
2. 依次向上调整整个堆的结构（一直到根即可）

插入流程如下(真的很精妙的！)

- 将 85 插入到堆中

![](https://user-gold-cdn.xitu.io/2020/4/26/171b6f4b39b666ab?w=641&h=484&f=png&s=138172)

- 第一步、将85添加到尾部

![](https://user-gold-cdn.xitu.io/2020/4/26/171b6f4e03ad107e?w=693&h=318&f=png&s=47831)

- 第二步、和父节点比较，然后交换

![](https://user-gold-cdn.xitu.io/2020/4/26/171b6f51441731ec?w=486&h=420&f=png&s=73479)

- 第三步、在和父节点进行比较。

![](https://user-gold-cdn.xitu.io/2020/4/26/171b6f5438b4c745?w=616&h=364&f=png&s=64259)

## Delete-Max 删除栈顶操作

HeapifyDown

1. 将堆尾元素替换顶部(相当于删除操作)
2. 依次从根部向下调整整个堆的结构（一直到堆尾即可）

- 第一步、将顶部元素删除

![](https://user-gold-cdn.xitu.io/2020/4/26/171b6ffe1cca4ecf?w=926&h=337&f=png&s=70219)

- 第二步、用尾部元素替换顶部元素

![](https://user-gold-cdn.xitu.io/2020/4/26/171b700884d079a2?w=466&h=310&f=png&s=42809)

- 第三步、顶部元素和儿子节点进行比较，哪个儿子大就替换

  ![](https://user-gold-cdn.xitu.io/2020/4/26/171b7024bc722217?w=564&h=319&f=png&s=52481)

- 第四步、选取较大的子节点进行交换，一直到尾部。

![](https://user-gold-cdn.xitu.io/2020/4/26/171b703b08d940d7?w=536&h=336&f=png&s=42436)

## 注意

- 堆是一个抽象的数据结构，表示可以非常迅速的拿到一堆数的最大值和最小值。它并不是二叉堆。

- 二叉堆是堆（优先队列 priority_queue）的一种常见且简单的实现；但是并不是最优的实现。（所以二叉堆并不是完全实用，工程代码中直接使用优先队列就可以了！）
- https//en.wikipedia.org/wiki/Heap_(data_structure)

# 源码推荐

- [BinaryHeap](https://shimo.im/docs/GpwwDq66kC9RC3PX/read)
- PriorityQueue
  - PriorityQueue 是小顶堆
  - PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1,o2)->(o2-o1)); 大顶堆

# 实战例题

- https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/

思路：

1. 排序 O(NlogN)
2. 堆 O(N logK)-> 插入到堆元素，logK
3. 快速排序

```java
public int[] getLeastNumbers(int[] arr, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for(int i=0;i<arr.length;i++){
        heap.add(arr[i]);
    }
    int[] ans = new int[k];
    for (int i=0; i<k;i++){
        ans[i] = heap.poll();
    }
    return ans;
}
```

总结：PriorityQueue 是一个最小堆！！！

- https://leetcode-cn.com/problems/sliding-window-maximum/

思路：

1. 双端队列（明天需要看队列）
2. 大顶堆

```java
public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0 || k == 0){
        return new int[0];
    }
    int n = nums.length;
    int[] result = new int[n-k+1];
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>();

    for(int i=0;i<n;++i){
        int start = i - k;
        if (start >= 0){
            maxPQ.remove(nums[start]);
        }
        maxPQ.offer(nums[i]);
        if (maxPQ.size() == k){
            result[i - k + 1] = maxPQ.peek();
        }
    }
    return result;
}
```

- https://leetcode-cn.com/problems/top-k-frequent-elements/

# 课后作业

- HeapSort ：自学 https://www.geeksforgeeks.org/heap-sort/
- https://leetcode-cn.com/problems/chou-shu-lcof/
- https://leetcode-cn.com/problems/top-k-frequent-elements/