## 面试思路

pow(x,n)
- 确认 x 和 n 的范围是什么，是整数还是小数。
- x 和 n  是否可以为 0 ，或者是正负值。
- x 和 n 的特殊值的处理 
- 边界设置
    - n = Integer.MIN_VALUE，-n 就会因为越界而出错。

- 这题明天需要好好理解一下这个幂和边界的关系
```java
public static double myPow(double x, int n) {
        // terminal
        if (n == Integer.MIN_VALUE && x>1) return 0;
        if (n == 0) return 1;
        // process current logic
        if (n < 0){
            n = -n;
            x = 1/x;
        }
        // drill down
        return (n%2 == 0)?myPow(x*x,n/2):x*myPow(x*x,n/2);
        // restore current status
    }
```
