/**
 * @program: algorithm008-class01
 * @description:
 * @author: ljd
 * @create: 2020-04-21 12:00
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

// 1.循环 O(N^2) O(1)
// 2.使用队列 把s的内容压入栈中，然后再pop O(N) O(N)
public class isSubsequence {
    public static void main(String[] args) {
        isSubsequence("abc","ahbgdc");
    }

    public static boolean isSubsequence(String s, String t) {


        Queue<Character> queue = new LinkedList<Character>();

        for(int i=0;i<s.length();i++){
            queue.offer(s.charAt(i));
        }

        for(int i=0;i<t.length();i++){
            if (queue.size() == 0) return true;
            if (t.charAt(i) == queue.element())
                queue.poll();
        }

        return queue.size() > 0?false:true;
    }

    /**
     * 解题思路
     * java中非常好的一个方法，indexOf(char c,int m)意思是从第m位置开始寻找该索引，找到则返回该索引，否则返回-1，利用该特性我们通过对索引处理从而获得解。
     *
     * 代码
     * class Solution {
     *     public boolean isSubsequence(String s, String t) {
     *         char[] arr = s.toCharArray();
     *         int j = -1;
     *         for(int i = 0;i<arr.length;i++) {
     *             j = t.indexOf(arr[i],j+1);
     *             if(j==-1) {
     *                 return false;
     *             }
     *         }
     *         return true;
     *     }
     * }
     *
     * 作者：yan-yu-yi-jiang-nan
     * 链接：https://leetcode-cn.com/problems/is-subsequence/solution/zhi-xing-yong-shi-0-ms-zai-suo-you-java-ti-jiao-77/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

//    public bool IsSubsequence(string s, string t)
//    {
//        int count = 0;
//        for (int i = 0; i < t.Length && count < s.Length; i++)
//        {
//            if (s[count] == t[i]) count++;
//        }
//        return count == s.Length;
//    }

//    public boolean isSubsequence(String s, String t) {
//        for(char c:s.toCharArray()){
//            int index = t.indexOf(c);
//            if(index < 0){
//                return false;
//            }
//            t = t.substring(index+1);
//        }
//        return true;
//    }
}
