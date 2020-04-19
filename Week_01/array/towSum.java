package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 *
 * 1.暴力破解 O(n~2) O(1)
 * 2.两遍hash表 O(n) O(n)
 * 3.一遍hash表 O(n) O(n)
 */
public class towSum {


    public int[] twoSum1(int[] nums, int target) {
        int a[] = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>i;j--){
                if (nums[i]+nums[j] == target){
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return a;
    }

    public int[] twoSum2(int[] nums, int target) {
        int a[] = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int value = target - nums[i];
            if (map.containsKey(value)){
                a[0] = i;
                a[1] = map.get(value);
                return a;
            }
            map.put(nums[i],i);
        }
        return a;
    }
}
