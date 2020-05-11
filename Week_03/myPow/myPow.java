package myPow;

/**
 * 思路1：循环 O(n) O(n)
 *
 * 思路2：分治法，拆分成子问题 2^10 = 2^5 * 2^5 时间复杂度变为 O(logn)
 * */
public class myPow {
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

    public static void main(String[] args) {
        System.out.println(myPow(2.100,3));
    }

}
