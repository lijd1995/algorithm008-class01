package slidingWindowMaximum;

/**
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 */

import java.util.PriorityQueue;

/**
 * 1.使用堆 O(n) O(k)
 */
public class slidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> (o2-o1)));
        for (int i=0;i<nums.length;i++){
            int start = i-k;
            if (start >= 0){
                queue.remove(nums[start]);
            }
            queue.offer(nums[i]);
            if (queue.size() == k){
                res[i-k+1] = queue.peek();
            }
        }
        return res;
    }
}
