/**
 * @program: algorithm008-class01
 * @description:
 * @author: ljd
 * @create: 2020-04-23 19:25
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路
 *
 * 1.暴力法 循环 O(n) O(n)
 */
public class fizzBuzz {

    // 方法1：循环
    /*
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%15 == 0) {
                list.add("FizzBuzz");
                continue;
            }
            if(i%3 == 0) {
                list.add("Fizz");
                continue;
            }
            if(i%5 == 0) {
                list.add("Buzz");
                continue;
            }
            list.add(String.valueOf(i));
        }
        return list;
    }
    */

    // 方法2：字符串连接
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            boolean divisibleBy3 = (n%3 == 0);
            boolean divisibleBy5 = (n%5 == 0);

            String str = new String();
            if(divisibleBy3){
                str += "Fizz";
            }
            if(divisibleBy5){
                str += "Buzz";
            }
            if(str.equals("")){
                str += Integer.toString(i);
            }
        }
        return list;
    }
}
