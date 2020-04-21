import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
 *
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 *
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 *
 * 示例 1:
 *
 * 输入: secret = "1807", guess = "7810"
 *
 * 输出: "1A3B"
 *
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 * 示例 2:
 *
 * 输入: secret = "1123", guess = "0111"
 *
 * 输出: "1A1B"
 *
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulls-and-cows
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 *
 * 1.循环将值存到 HashMap，然后遍历 O(N) O(N)
 *
 * 2.定义两个char桶，然后减法 O(N) O(1)
 */

public class bullsAndCows {

    /**
     * 方法1：遍历 O(N) O(N)
     * @param secret
     * @param guess
     * @return
     */
//    public static String getHint(String secret, String guess) {
//        HashMap<Character,Integer> map = new HashMap<>();
//        List<Character> list = new ArrayList();
//        int bulls=0,cows=0;
//        // 将结果存到 HashMap
//        for(int i=0;i<secret.length();i++){
//            if (secret.charAt(i) == guess.charAt(i)){
//                bulls++;
//            }else{
//                list.add(guess.charAt(i));
//                map.put(secret.charAt(i),map.containsKey(secret.charAt(i))?map.get(secret.charAt(i))+1:1);
//            }
//        }
//        // 用列表存取多余的 guess，然后遍历 list
//        for (Character c:list){
//            if (map.containsKey(c)){
//                cows++;
//                Integer value = map.get(c);
//                if (--value == 0) {
//                    map.remove(c);
//                    continue;
//                }
//                map.put(c,value);
//            }
//        }
//        return bulls + "A" + cows + "B";
//    }

    /**
     * 两个桶
     * @param secret
     * @param guess
     * @return
     */
//    public static String getHint(String secret, String guess) {
//        // 定义两个char桶
//
//        char[] bucketSecret = new char[10];
//        char[] guessSecret = new char[10];
//        int bulls=0,cows=0;
//
//        for(int i=0;i<secret.length();i++){
//            if (secret.charAt(i) == guess.charAt(i)){
//                bulls++;
//            }else{
//                bucketSecret[secret.charAt(i)-'0']++;
//                guessSecret[guess.charAt(i)-'0']++;
//            }
//        }
//
//        for(int i=0;i<10;i++)
//            if (bucketSecret[i]!=0 && guessSecret[i]!=0){
//                cows += bucketSecret[i]-guessSecret[i] >= 0?guessSecret[i]:bucketSecret[i];
//            }
//        return bulls + "A" + cows + "B";
//    }

    /***
     * 最优的办法，遍历一次
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

}
