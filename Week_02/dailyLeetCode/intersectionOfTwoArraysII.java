/**
 * @program: algorithm008-class01
 * @description:
 * @author: ljd
 * @create: 2020-04-21 10:50
 */

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 * 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. 排序，然后遍历 O(N^2) O(N)
 * 2. 将第一个的结果存在hash 表中，然后遍历第二个 O(n),O(n)
 */
public class intersectionOfTwoArraysII {

    // 暴力法，写low了
    /* public int[] intersect(int[] nums1, int[] nums2) {
        // 对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pnt1 = 0;
        int pnt2 = 0;
        ArrayList<Integer> myList = new ArrayList<Integer>();
        while((pnt1 < nums1.length) &&(pnt2< nums2.length)){
            if(nums1[pnt1]<nums2[pnt2]){
                pnt1++;
            }
            else{
                if(nums1[pnt1]>nums2[pnt2]){
                    pnt2++;
                }
                else{
                    myList.add(nums1[pnt1]);
                    pnt1++;
                    pnt2++;
                }
            }
        }
        int[] res = new int[myList.size()];
        for(int i = 0; i<res.length; i++){
            res[i] = (Integer)myList.get(i);
        }
        return res;
    }
    */

    // hash 法
//    public int[] intersect(int[] nums1, int[] nums2) {
//        List<Integer> list = new ArrayList<>();
//        // 将结果存放在 hash 表中，并且 +1;
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<nums1.length;i++)
//            map.put(nums1[i],map.containsKey(nums1[i])?map.get(nums1[i])+1:1);
//        for(int n:nums2){
//            if (map.containsKey(n)){
//                list.add(n);
//                int value = map.get(n) - 1;
//                if (value > 0)
//                    map.put(n,value);
//                else
//                    map.remove(n);
//            }
//        }
//
//        // 返回结果
//        int[] nums = new int[list.size()];
//        for(int i=0;i<list.size();i++)
//            nums[i] = list.get(i);
//        return nums;
//    }


    /**
     * 优化后1
     *
     * 使用了  Java 8 getOrDefault  和 map.remove
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // freq count for nums1
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
        // collect result
        ArrayList<Integer> result = new ArrayList();
        for (int num: nums2) {
            if (map.containsKey(num)){
                result.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        // convert result
        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    /**
     * 优化后2
     *
     * 使用了 java 8 stream 方法
     */
//    public int[] intersect(int[] nums1, int[] nums2) {
//        Map<Integer, Long> map = Arrays.stream(nums2).boxed().collect(Collectors.groupingBy(e->e, Collectors.counting()));
//        return Arrays.stream(nums1).filter(e ->{
//            if(!map.containsKey(e)) return false;
//            map.put(e, map.get(e) - 1);
//            if(map.get(e) == 0) map.remove(e);
//            return true;
//        }).toArray();
//    }


}
