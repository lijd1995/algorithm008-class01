package array; /**
 * @program: Week_01
 * @description:
 * @author: ljd
 * @create: 2020-04-16 09:52
 */

/*
给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。

        示例 1：

        输入：n = 234
        输出：15
        解释：
        各位数之积 = 2 * 3 * 4 = 24
        各位数之和 = 2 + 3 + 4 = 9
        结果 = 24 - 9 = 15
        示例 2：

        输入：n = 4421
        输出：21
        解释：
        各位数之积 = 4 * 4 * 2 * 1 = 32
        各位数之和 = 4 + 4 + 2 + 1 = 11
        结果 = 32 - 11 = 21
         

        提示：

        1 <= n <= 10^5

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/**
 * 思路
 *
 * 1.loop O(logN) O(1)
 */

public class subtractProductAndSum {

    public static void main(String[] args) {
        subtractProductAndSum(234);
    }

    public static int subtractProductAndSum(int n) {
        // 1.循环除以取余
        int product=1;
        int sum=0;
        while(n/10 != 0){
            product = product * (n%10);
            sum = sum + n%10;
            n = n/10;
        }
        return product - sum;
    }
}
