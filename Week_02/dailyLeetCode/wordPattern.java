/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 思路
 *
 *  1.通过 Hash 表来建立映射关系 O(N)
 *
 */

public class wordPattern {

//    public boolean wordPattern(String pattern, String str) {
//        String[] s = str.split(" ");
//        // 长度不一致
//        if (pattern.length() != s.length) return false;
//        // 创建 hash 表建立映射
//        Map<Character,String> map = new HashMap<>();
//        for(int i=0;i<pattern.length();i++){
//            if (!map.containsKey(pattern.charAt(i))){
//                if (map.containsValue(s[i])) return false;
//                map.put(pattern.charAt(i),s[i]);
//            }else{
//                if (!map.get(pattern.charAt(i)).equals(s[i])) return false;
//            }
//        }
//        return true;
//    }

    // 牛逼的代码
    // 通过返回值来进行判断
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (int i=0; i<words.length; ++i)
            if (!Objects.equals(index.put(pattern.charAt(i), i),
                    index.put(words[i], i)))
                return false;
        return true;
    }
}
