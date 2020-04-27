package getKthMagicNumber;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 *
 * 输入: k = 5
 *
 * 输出: 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 思路
 *
 * 1.从 1 开始进行循环判断，满足 3,5,7 的关系才行，复杂度至少O(n^2)
 * 2.动态规划
 */
public class getKthMagicNumber {
    /**
     * 动态规划
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        int p3=0,p5=0,p7=0;
        int[] a = new int[k];
        a[0] = 1;
        for (int i=1;i<a.length;i++){
            a[i] = Math.min(a[p3]*3,Math.min(a[p5]*5,a[p7]*7));
            if (a[i] == a[p3]*3) p3++;
            if (a[i] == a[p5]*5) p5++;
            if (a[i] == a[p7]*7) p7++;
        }
        return a[k-1];
    }
}
