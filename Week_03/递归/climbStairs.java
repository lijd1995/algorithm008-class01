package 递归;

public class climbStairs {

    /**
     * 傻递归时间复杂度太高
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // 终结条件
        if(n == 1) return 1;
        if(n == 2) return 2;
        // 逻辑处理
        return climbStairs(n-2) + climbStairs(n-1);
        // 调用下一层

        // 处理当前层
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if(n <= 2) return n;
        int f1 = 1,f2 = 2,f3 = 3;
        for(int i=3;i<=n;i++){
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
