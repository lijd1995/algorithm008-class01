```java
// 使用优先队列
 public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int num:arr){
            queue.offer(num);
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = queue.poll();
        }
        return res;
    }
```